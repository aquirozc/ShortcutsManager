plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    mavenCentral()
    maven { url =  uri("https://jitpack.io") }
}

dependencies {
    implementation("com.github.3breadt:dd-plist:v1.27.0")
    implementation("com.github.apache:commons-imaging:rel~commons-imaging-1.0-alpha3")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8

}

application {
    mainClass.set("com.aquirozc.shortcutsmanager.init.ShortcutsManager")
    applicationName = "ShortcutsManager"
}

tasks{

    build{
        dependsOn("shadowJar")
    }

    shadowJar{
        manifest{
            attributes("MainClass" to "com.aquirozc.shortcutsmanager.init.ShortcutsManager")
        }
        minimize{
            exclude(dependency( "com.github.3breadt:dd-plist:v1.27.0"))
            exclude(dependency("com.github.apache:commons-imaging:rel~commons-imaging-1.0-alpha3"))
        }
    }

}