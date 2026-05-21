package com.example.experimentaltesting

import org.junit.Ignore
import org.junit.runner.RunWith
import org.junit.runners.Suite


@Ignore
@RunWith(Suite::class)
@Suite.SuiteClasses(
    LoginTests::class,
    ProfileTests::class
)
class MyTestSuite {/*Kann leer gelassen werden */}