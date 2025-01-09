plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/io.swagger.core.v3/swagger-core
    implementation("io.swagger.core.v3:swagger-core:2.2.27")

}

tasks.test {
    useJUnitPlatform()
}