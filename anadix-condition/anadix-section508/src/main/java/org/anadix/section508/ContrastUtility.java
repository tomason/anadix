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
package org.anadix.section508;

import java.awt.Color;

public final class ContrastUtility {

	private ContrastUtility() {}

	public static String normalizeColor(String color) {
		if (color == null) {
			throw new NullPointerException("color must not be null");
		}

		if (color.startsWith("#")) {
			return color;//color.substring(1);
		}

		if ("black".equalsIgnoreCase(color)) {
			return "#000000";
		}
		if ("silver".equalsIgnoreCase(color)) {
			return "#C0C0C0";
		}
		if ("gray".equalsIgnoreCase(color)) {
			return "#808080";
		}
		if ("white".equalsIgnoreCase(color)) {
			return "#FFFFFF";
		}
		if ("maroon".equalsIgnoreCase(color)) {
			return "#800000";
		}
		if ("red".equalsIgnoreCase(color)) {
			return "#FF0000";
		}
		if ("purple".equalsIgnoreCase(color)) {
			return "#800080";
		}
		if ("fuchsia".equalsIgnoreCase(color)) {
			return "#FF00FF";
		}
		if ("green".equalsIgnoreCase(color)) {
			return "#008000";
		}
		if ("lime".equalsIgnoreCase(color)) {
			return "#00FF00";
		}
		if ("olive".equalsIgnoreCase(color)) {
			return "#808000";
		}
		if ("yellow".equalsIgnoreCase(color)) {
			return "#FFFF00";
		}
		if ("navy".equalsIgnoreCase(color)) {
			return "#000080";
		}
		if ("blue".equalsIgnoreCase(color)) {
			return "#0000FF";
		}
		if ("teal".equalsIgnoreCase(color)) {
			return "#008080";
		}
		if ("aqua".equalsIgnoreCase(color)) {
			return "#00FFFF";
		}

		throw new IllegalArgumentException("Can't parse color: " + color);
	}

	public static double countRelativeLuminance(String color) {
		if (color == null) {
			return -1;
		}
		Color c = Color.decode(normalizeColor(color));

		double rsrgb = c.getRed() / 255.0;
		double gsrgb = c.getGreen() / 255.0;
		double bsrgb = c.getBlue() / 255.0;

		double r;
		if (rsrgb <= 0.03928) {
			r = rsrgb / 12.92;
		} else {
			r = Math.pow((rsrgb + 0.055) / 1.055, 2.4);
		}

		double g;
		if (gsrgb <= 0.03928) {
			g = gsrgb / 12.92;
		} else {
			g = Math.pow((gsrgb + 0.055) / 1.055, 2.4);
		}

		double b;
		if (bsrgb <= 0.03928) {
			b = bsrgb / 12.92;
		} else {
			b = Math.pow((bsrgb + 0.055) / 1.055, 2.4);
		}

		double luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;

		return luminance;
	}

	public static double getContrastRatio(double luminance1, double luminance2) {
		double l1 = Math.max(luminance1, luminance2);
		double l2 = Math.min(luminance1, luminance2);

		double contrast = (l1 + 0.05) / (l2 + 0.05);

		return contrast;
	}
}
