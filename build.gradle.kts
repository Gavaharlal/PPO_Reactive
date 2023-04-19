import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(group = "org.mongodb", name = "mongodb-driver-rx", version = "1.5.0")
    implementation(group = "io.reactivex", name = "rxjava", version = "1.0.2")
    implementation(group = "io.reactivex", name = "rxnetty-http", version = "0.5.3")
    implementation(group = "io.reactivex", name = "rxnetty-common", version = "0.5.3")

//    compile group: 'org.mongodb', name: 'mongodb-driver-rx', version: '1.5.0'
//    compile group: 'io.reactivex', name: 'rxnetty-common', version: '0.5.3'
//    compile group: 'io.reactivex', name: 'rxnetty-http', version: '0.5.3'
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}