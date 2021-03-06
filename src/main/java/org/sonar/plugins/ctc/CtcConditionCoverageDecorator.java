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
package org.sonar.plugins.ctc;

import org.sonar.api.ce.measure.MeasureComputer.MeasureComputerContext;
import org.sonar.api.config.Settings;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.measures.Metric;
import org.sonar.plugins.ctc.api.measures.CtcMetrics;

@SuppressWarnings("rawtypes")
public class CtcConditionCoverageDecorator extends CtcCoverageDecorator {

  public CtcConditionCoverageDecorator(Settings settings) {
    super(settings);
  }

  @Override
  public MeasureComputerDefinition define(MeasureComputerDefinitionContext def) {
    return def.newDefinitionBuilder()
      .setOutputMetrics(CtcMetrics.CTC_CONDITION_COVERAGE.key())
      .setInputMetrics( CtcMetrics.CTC_UNCOVERED_CONDITIONS.key(),
                        CtcMetrics.CTC_CONDITIONS_TO_COVER.key())
      .build();
  }

  @Override
  protected Metric getGeneratedMetric() {
    return CtcMetrics.CTC_CONDITION_COVERAGE;
  }

  @Override
  protected Integer countElements(MeasureComputerContext context) {
    Measure measure = context.getMeasure(CtcMetrics.CTC_CONDITIONS_TO_COVER.key());
    if (measure == null) {
      return null;
    } else {
      return measure.getIntValue();
    }
  }

  @Override
  protected Integer countUncoveredElements(MeasureComputerContext context) {
    Measure measure = context.getMeasure(CtcMetrics.CTC_UNCOVERED_CONDITIONS.key());
    if (measure == null) {
      return null;
    } else {
      return measure.getIntValue();
    }
  }

}
