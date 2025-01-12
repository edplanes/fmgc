package com.edplanes.fmgc;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.edplanes")
public class ModularArchitectureTest {

        @ArchTest
        public static final ArchRule commons_should_not_depend_on_auth = ArchRuleDefinition.noClasses()
                        .that().resideInAPackage("..commons..")
                        .should().dependOnClassesThat().resideInAPackage("..auth..");

        @ArchTest
        public static final ArchRule commons_should_not_depend_on_security = ArchRuleDefinition.noClasses()
                        .that().resideInAPackage("..commons..")
                        .should().dependOnClassesThat().resideInAPackage("..security..");

}
