FROM java:8
COPY JavaAutoBuild.java EmailAccountTest.java
RUN javac EmailAccountTest.java

CMD ["java", "EmailAccountTest"]