plugins {
	kotlin("multiplatform") version "2.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

kotlin {
	js {
		compilerOptions.target = "es2015"
		useEsModules()
		nodejs {
			binaries.executable()
		}
	}
	sourceSets {
		jsMain {
			dependencies {
				implementation("io.ktor:ktor-client-core:3.0.0-beta-2")
			}
		}
	}
}