/*
 * Copyright (C) 2003-2009 eXo Platform SAS.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.chromattic.test.common.collection.delta;

import junit.framework.TestCase;
import org.chromattic.common.collection.delta.DeltaList;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class DeltaListTestCase extends TestCase {

  public void testFoo() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    assertEquals(0, (int)deltaList.get(0));
    assertEquals(1, (int)deltaList.get(1));
    assertEquals(2, (int)deltaList.get(2));
    try {
      deltaList.get(3);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testGetAtMinus1() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    try {
      deltaList.get(-1);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testAddAt0() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    deltaList.add(0, -1);
    assertEquals(-1, (int)deltaList.get(0));
    assertEquals(0, (int)deltaList.get(1));
    assertEquals(1, (int)deltaList.get(2));
    assertEquals(2, (int)deltaList.get(3));
    try {
      deltaList.get(4);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }
  
  public void testAddAt1() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    deltaList.add(1, -1);
    assertEquals(0, (int)deltaList.get(0));
    assertEquals(-1, (int)deltaList.get(1));
    assertEquals(1, (int)deltaList.get(2));
    assertEquals(2, (int)deltaList.get(3));
    try {
      deltaList.get(4);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testAddAt2() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    deltaList.add(2, -1);
    assertEquals(0, (int)deltaList.get(0));
    assertEquals(1, (int)deltaList.get(1));
    assertEquals(-1, (int)deltaList.get(2));
    assertEquals(2, (int)deltaList.get(3));
    try {
      deltaList.get(4);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testAddAt3() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    deltaList.add(3, -1);
    assertEquals(0, (int)deltaList.get(0));
    assertEquals(1, (int)deltaList.get(1));
    assertEquals(2, (int)deltaList.get(2));
    assertEquals(-1, (int)deltaList.get(3));
    try {
      deltaList.get(4);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testRemoveAt0() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    assertEquals(0, (int)deltaList.remove(0));
    assertEquals(1, (int)deltaList.get(0));
    assertEquals(2, (int)deltaList.get(1));
    try {
      deltaList.get(3);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testRemoveAt1() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    assertEquals(1, (int)deltaList.remove(1));
    assertEquals(2, deltaList.size());
    assertEquals(0, (int)deltaList.get(0));
    assertEquals(2, (int)deltaList.get(1));
    try {
      deltaList.get(3);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testRemoveAt2() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    assertEquals(2, (int)deltaList.remove(2));
    assertEquals(0, (int)deltaList.get(0));
    assertEquals(1, (int)deltaList.get(1));
    try {
      deltaList.get(2);
      fail();
    }
    catch (IndexOutOfBoundsException e) {
    }
  }

  public void testRemoveAll1() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    assertEquals(0, (int)deltaList.remove(0));
    assertEquals(2, deltaList.size());
    assertEquals(1, (int)deltaList.remove(0));
    assertEquals(1, deltaList.size());
    assertEquals(2, (int)deltaList.remove(0));
    assertEquals(0, deltaList.size());
  }

  public void testRemoveAll2() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    assertEquals(2, (int)deltaList.remove(2));
    assertEquals(2, deltaList.size());
    assertEquals(1, (int)deltaList.remove(1));
    assertEquals(1, deltaList.size());
    assertEquals(0, (int)deltaList.remove(0));
    assertEquals(0, deltaList.size());
  }

/*
  public void testRemoveAdded() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    deltaList.add(1, 1);
    deltaList.remove(1);
    assertEquals(2, deltaList.getComplexity());
  }

  public void testAddRemoved() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    deltaList.remove(1);
    deltaList.add(1 , 1);
    assertEquals(2, deltaList.getComplexity());
  }

  public void testRemoveAll() {
    List<Integer> list = Arrays.asList(0, 1, 2);
    DeltaList<Integer> deltaList = new DeltaList<Integer>(list);
    deltaList.remove(0);
    deltaList.remove(1);
    deltaList.remove(2);
    assertEquals(2, deltaList.getComplexity());
  }
*/
}
