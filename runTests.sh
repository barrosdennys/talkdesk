# Run tests and generate .xml reports
mvn test
mvn surefire-report:report-only
mvn site -DgenerateReports=false
