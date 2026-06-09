# Software Engineering II Project — Defect Prediction on OpenJPA

**Author:** Daniel Garoz Vazquez  
**University:** Tor Vergata, Rome (Erasmus from URJC, Madrid)  
**Course:** Ingegneria del Software II — 2025/26  
**Instructors:** Prof. Davide Falessi (M1-M3) + Prof. Guglielmo De Angelis (M4)

This repository is a fork of Apache OpenJPA used as the case-study project for the course.
The work below is mine; the rest of the repository is the original Apache OpenJPA code.

## Project structure (my contribution)

| Path | Content |
|---|---|
| `tools/GetVersionsFromJIRA/` | Adapted from instructor's template — JIRA REST API release retrieval (M1). |
| `tools/GetTicketsID/` | Adapted from instructor's template — JIRA REST API bug ticket retrieval (M1). |
| `tools/M2WekaPipeline/` | Walk-forward defect prediction classifier evaluation (M2) and What-If counterfactual analysis (M3). |
| `m4/` | LLM-assisted refactoring experiments on classes C_A (ClassMetaData) and C_B (Math). Contains C_X versions and test suites (BB, LLM, CF). |
| `m4_mutation/` | PIT mutation testing, Randoop random tests, variant preservation analysis, Nelson reliability estimation, PIT HTML reports. |
| `.github/workflows/m4-mutation.yml` | GitHub Actions Continuous Integration pipeline. |

## Datasets and results (root CSVs)

- `dataset_labeled.csv` — Final labeled dataset from M1 (10,290 rows × 66 columns).
- `smells_per_class.csv` — PMD smells aggregated by class.
- `commit_metrics.csv` — Process metrics from git log.
- `ticket_av.csv`, `ticket_files.csv` — Bug ticket linkage and AV resolution.
- `m2_results.csv` — Walk-forward classifier evaluations (288 rows = 12 iterations × 24 configurations).
- `A.csv`, `B.csv`, `Bplus.csv`, `C.csv` — Dataset variants for M3 What-If analysis.
- `m3_results_*.csv` — What-If counterfactual results.

## Reports

Submitted as separate PDFs through each instructor's procedure:

- `Report_Falessi_M1_M3.pdf` — Module: Measurements and Improvement of Software Quality (M1, M2, M3).
- `Report_DeAngelis_M4.pdf` — Module: Software Testing (M4).
- `classes.txt` — Selected refactoring classes in alphabetical order (De Angelis requirement).

## Key results

| Milestone | Headline result |
|---|---|
| M1 | 13-release dataset, 10,290 rows, 18.6% buggy ratio, JIRA-based labeling + Proportion estimation (P median = 1.5). |
| M2 | Best classifier: Random Forest + SMOTE, AUC = 0.897 (walk-forward, 12 iterations). |
| M3 | Counterfactual analysis: 1.5% of predicted buggy classes preventable by setting NSmells to zero. |
| M4 | Mutation score 13% → 25% → 29% across three iterations. Reliability R = 1.0 on covered code. Tests act as safety net for LLM refactoring (4× code retention improvement on the complex class with Black-Box tests). |

## CI status

Workflow: M4 Mutation Testing — compiles, runs JUnit tests, executes PIT mutation analysis, and uploads the HTML report as a build artifact on every push affecting `m4_mutation/`.

