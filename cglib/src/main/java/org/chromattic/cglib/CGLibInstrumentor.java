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

package org.chromattic.cglib;

import net.sf.cglib.proxy.Callback;
import org.chromattic.spi.instrument.Instrumentor;
import org.chromattic.spi.instrument.ProxyType;
import org.chromattic.spi.instrument.MethodHandler;
import net.sf.cglib.proxy.Factory;

/**
 * @author <a href="mailto:julien.viet@exoplatform.com">Julien Viet</a>
 * @version $Revision$
 */
public class CGLibInstrumentor implements Instrumentor {

  public <O> ProxyType<O> getProxyClass(Class<O> clazz) {
    return new CGLibProxyType<O>(clazz);
  }

  public MethodHandler getInvoker(Object proxy) {
    if (proxy instanceof Factory) {
      Factory factory = (Factory)proxy;
      Callback callback = factory.getCallback(0);
      if (callback instanceof MethodInterceptorInvoker) {
        return ((MethodInterceptorInvoker)callback).invoker;
      }
    }
    return null;
  }
}
