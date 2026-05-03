import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

class RetrieveTicketsID {

   private static String readAll(Reader rd) throws IOException {
      StringBuilder sb = new StringBuilder();
      int cp;
      while ((cp = rd.read()) != -1) {
         sb.append((char) cp);
      }
      return sb.toString();
   }

   public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
      InputStream is = new URL(url).openStream();
      try {
         BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
         String jsonText = readAll(rd);
         JSONObject json = new JSONObject(jsonText);
         return json;
      } finally {
         is.close();
      }
   }

   public static void main(String[] args) throws IOException, JSONException {
      String projName = "OPENJPA";
      Integer j = 0, i = 0, total = 1;

      String outName = projName + "TicketsInfo.csv";
      FileWriter fileWriter = new FileWriter(outName);
      fileWriter.append("Key,Created,ResolutionDate,AffectedVersions\n");

      do {
         j = i + 1000;
         String url = "https://issues.apache.org/jira/rest/api/2/search?jql=project=%22"
                + projName + "%22AND%22issueType%22=%22Bug%22AND(%22status%22=%22closed%22OR"
                + "%22status%22=%22resolved%22)AND%22resolution%22=%22fixed%22&fields=key,resolutiondate,versions,created&startAt="
                + i.toString() + "&maxResults=" + j.toString();
         JSONObject json = readJsonFromUrl(url);
         JSONArray issues = json.getJSONArray("issues");
         total = json.getInt("total");
         for (; i < total && i < j; i++) {
            JSONObject issue = issues.getJSONObject(i % 1000);
            String key = issue.get("key").toString();
            JSONObject fields = issue.getJSONObject("fields");

            String created = fields.has("created") && !fields.isNull("created")
                ? fields.get("created").toString() : "";
            String resolutionDate = fields.has("resolutiondate") && !fields.isNull("resolutiondate")
                ? fields.get("resolutiondate").toString() : "";

            StringBuilder versions = new StringBuilder();
            if (fields.has("versions") && !fields.isNull("versions")) {
               JSONArray versionsArray = fields.getJSONArray("versions");
               for (int v = 0; v < versionsArray.length(); v++) {
                  if (v > 0) versions.append(";");
                  versions.append(versionsArray.getJSONObject(v).get("name").toString());
               }
            }

            fileWriter.append(key).append(",")
                      .append(created).append(",")
                      .append(resolutionDate).append(",")
                      .append(versions.toString()).append("\n");

            System.out.println(key);
         }
      } while (i < total);

      fileWriter.flush();
      fileWriter.close();
      System.out.println("Done. Total tickets: " + total + ". CSV: " + outName);
      return;
   }
}
