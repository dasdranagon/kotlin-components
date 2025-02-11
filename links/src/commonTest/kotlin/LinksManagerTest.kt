/*
 Copyright 2023 Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package com.splendo.kaluga.links

import com.splendo.kaluga.links.handler.LinksHandler
import com.splendo.kaluga.test.base.mock.call
import com.splendo.kaluga.test.base.mock.matcher.ParameterMatcher.Companion.any
import com.splendo.kaluga.test.base.mock.matcher.ParameterMatcher.Companion.eq
import com.splendo.kaluga.test.base.mock.on
import com.splendo.kaluga.test.base.mock.parameters.mock
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals

class LinksManagerTest {

    @Serializable
    data class Person(val name: String, val surname: String, val spokenLanguages: List<Language> = emptyList()) {
        companion object {
            val dummyUrl = "http://url.com?name=Corrado&surname=Quattrocchi&spokenLanguages=ITALIAN&spokenLanguages=ENGLISH&spokenLanguages=DUTCH"
            val dummyPerson = Person(
                "Corrado",
                "Quattrocchi",
                listOf(Language.ITALIAN, Language.ENGLISH, Language.DUTCH),
            )
        }
    }

    enum class Language {
        ITALIAN,
        ENGLISH,
        DUTCH,
    }

    private val handler = MockLinksHandler()
    private val linksManager = DefaultLinksManager(handler)

    @Test
    fun testHandleIncomingLinkSucceed() {
        handler.extractQueryAsMapMock
            .on(eq(Person.dummyUrl))
            .doReturn(
                mapOf(
                    Person::name.name to listOf(Person.dummyPerson.name),
                    Person::surname.name to listOf(Person.dummyPerson.surname),
                    Person::spokenLanguages.name to Person.dummyPerson.spokenLanguages.map { it.name },
                ),
            )
        val result = linksManager.handleIncomingLink(Person.dummyUrl, Person.serializer())

        assertEquals(Person.dummyPerson, result)
    }

    @Test
    fun testHandleIncomingLinkFailed() {
        handler.extractQueryAsMapMock.on(any()).doReturn(emptyMap())
        val query = ""

        val result = linksManager.handleIncomingLink(query, Person.serializer())
        assertEquals(null, result)
    }

    @Test
    fun testHandleOutgoingLinkSucceed() {
        val url = "https://valid-link?parameter=1"
        handler.isValidMock.on(eq(url)).doReturn(true)
        val result = linksManager.validateLink(url)
        assertEquals(url, result)
    }

    @Test
    fun testHandleOutgoingLinkFailed() {
        val url = "not valid"
        handler.isValidMock.on(eq(url)).doReturn(false)
        val result = linksManager.validateLink(url)
        assertEquals(null, result)
    }
}

private class MockLinksHandler : LinksHandler {

    val extractQueryAsMapMock = this::extractQueryAsMap.mock()
    val isValidMock = this::isValid.mock()

    override fun extractQueryAsMap(url: String): Map<String, List<String>> = extractQueryAsMapMock.call(url)
    override fun isValid(url: String): Boolean = isValidMock.call(url)
}
