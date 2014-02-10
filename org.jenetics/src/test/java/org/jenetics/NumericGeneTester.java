/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version @__version__@ &mdash; <em>$Date$</em>
 * @since @__version__@
 */
public abstract class NumericGeneTester<
	N extends Number & Comparable<N>,
	G extends NumericGene<N,G>
>
	extends GeneTester<G>
{

	@Test
	public void newInstanceFromNumber() {
		for (int i = 0; i < 100; ++i) {
			final G gene1 = getFactory().newInstance();
			final G gene2 = gene1.newInstance(gene1.getAllele());

			Assert.assertEquals(gene2, gene1);
		}
	}

	@Test
	public void minMax() {
		for (int i = 0; i < 100; ++i) {
			final G gene = getFactory().newInstance();

			Assert.assertTrue(gene.getNumber().compareTo(gene.getMin()) >= 0);
			Assert.assertTrue(gene.getNumber().compareTo(gene.getMax()) <= 0);
		}
	}

	@Test
	public void compareTo() {
		for (int i = 0; i < 100; ++i) {
			final G gene1 = getFactory().newInstance();
			final G gene2 = getFactory().newInstance();

			if (gene1.getNumber().compareTo(gene2.getNumber()) > 0) {
				Assert.assertTrue(gene1.compareTo(gene2) > 0);
			} else if (gene1.getNumber().compareTo(gene2.getNumber()) < 0) {
				Assert.assertTrue(gene1.compareTo(gene2) < 0);
			} else {
				Assert.assertTrue(gene1.compareTo(gene2) == 0);
			}
		}
	}

}
