/*
 * Testwell CTC++ Plugin
 * Copyright (C) 2014 Verifysoft Technology GmbH
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.ctc.api.measures;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.Test;
import static org.fest.assertions.Assertions.*;

public class CtcMetricsTest {

  private CtcMetrics testee;

  public static Logger LOG = LoggerFactory.getLogger(CtcMetricsTest.class);

  @Before
  public void setUp() throws Exception {
    testee = new CtcMetrics();
  }

  @Test
  public void testGetMetrics() {
    LOG.info("Starting Metrics test.");
    LOG.debug("Metrics: {}",testee.getMetrics());
    assertThat(testee.getMetrics()).doesNotHaveDuplicates()
    .hasSize(13);
  }

}
