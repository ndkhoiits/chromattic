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

package org.chromattic.metamodel.typegen;

import org.chromattic.metamodel.mapping2.BeanMapping;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class NodeDefinition2 extends NodeDefinition {

  /** . */
  final Set<BeanMapping> mappings;

  public NodeDefinition2(String name, boolean mandatory, boolean autocreated) {
    super(name, mandatory, autocreated);

    //
    this.mappings = new HashSet<BeanMapping>();
  }

  public String getNodeTypeName() {
    // Try to find the common ancestor type of all types
    BeanMapping ancestorMapping = null;
    foo:
    for (BeanMapping relatedMapping1 : mappings) {
      for (BeanMapping relatedMapping2 : mappings) {
        if (!relatedMapping1.getBean().getClassType().isAssignableFrom(relatedMapping2.getBean().getClassType())) {
          continue foo;
        }
      }
      ancestorMapping = relatedMapping1;
      break;
    }

    //
    if (ancestorMapping == null) {
      return "nt:base";
    } else {
      return ancestorMapping.getNodeTypeName();
    }
  }
}