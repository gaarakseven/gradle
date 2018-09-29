// tag::no-accessors[]
// tag::dependencies[]
// tag::project-extension[]
// tag::tasks[]
// tag::project-container-extension[]
apply(plugin = "java-library")

// end::project-extension[]
// end::tasks[]
// end::project-container-extension[]
dependencies {
    "api"("junit:junit:4.12")
    "implementation"("junit:junit:4.12")
    "testImplementation"("junit:junit:4.12")
}

configurations {
    "implementation" {
        resolutionStrategy.failOnVersionConflict()
    }
}
// end::dependencies[]

// tag::project-extension[]
// tag::project-container-extension[]
configure<SourceSetContainer> {
    named("main") {
        java.srcDir("src/core/java")
    }
}
// end::project-container-extension[]

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
// end::project-extension[]

// tag::tasks[]
tasks {
    named<Test>("test") {
        testLogging.showExceptions = true
    }
}
// end::tasks[]
// end::no-accessors[]

repositories {
    jcenter()
}
