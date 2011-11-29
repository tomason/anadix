/*
 * Copyright 2011 Tomas Schlosser
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.anadix.swingparser;

import static org.mockito.Mockito.mock;

import org.anadix.Source;
import org.anadix.factories.SourceFactory;
import org.anadix.html.HTMLElementFactory;
import org.anadix.mock.MockElementFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class SwingParserTest {
    private HTMLElementFactory factory;
    private SwingParser parser;
    private Source source;

    @BeforeMethod(alwaysRun = true)
    public void prepareInstances() {
        factory = mock(HTMLElementFactory.class);
        parser = new SwingParser();
        source = SourceFactory.newStringSource("<html><head></head><body></body></html>");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testParse1() throws Exception {
        parser.parse(null, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testParse2() throws Exception {
        parser.parse(factory, null);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testParse3() throws Exception {
        parser.parse(null, source);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testParse4() throws Exception {
        parser.parse(new MockElementFactory(), source);
    }

    public void testParse5() throws Exception {
        parser.parse(factory, source);
    }

}
