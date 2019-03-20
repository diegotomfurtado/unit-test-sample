FROM java:8
COPY EmailAccountTest.java EmailAccountTest.java
RUN javac EmailAccountTest.java

CMD ["java", "EmailAccountTest"]