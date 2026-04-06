FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy all files
COPY . .

# Give permission to mvnw
RUN chmod +x mvnw

# Build the project
RUN ./mvnw clean package -DskipTests

# Expose port (Render will override with PORT env)
EXPOSE 8080

# Run the jar
CMD ["sh", "-c", "java -jar target/*.jar"]