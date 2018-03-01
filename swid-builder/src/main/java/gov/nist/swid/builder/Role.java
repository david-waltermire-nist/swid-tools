/**
 * Portions of this software was developed by employees of the National Institute
 * of Standards and Technology (NIST), an agency of the Federal Government.
 * Pursuant to title 17 United States Code Section 105, works of NIST employees are
 * not subject to copyright protection in the United States and are considered to
 * be in the public domain. Permission to freely use, copy, modify, and distribute
 * this software and its documentation without fee is hereby granted, provided that
 * this notice and disclaimer of warranty appears in all copies.
 *
 * THE SOFTWARE IS PROVIDED 'AS IS' WITHOUT ANY WARRANTY OF ANY KIND, EITHER
 * EXPRESSED, IMPLIED, OR STATUTORY, INCLUDING, BUT NOT LIMITED TO, ANY WARRANTY
 * THAT THE SOFTWARE WILL CONFORM TO SPECIFICATIONS, ANY IMPLIED WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND FREEDOM FROM
 * INFRINGEMENT, AND ANY WARRANTY THAT THE DOCUMENTATION WILL CONFORM TO THE
 * SOFTWARE, OR ANY WARRANTY THAT THE SOFTWARE WILL BE ERROR FREE. IN NO EVENT
 * SHALL NIST BE LIABLE FOR ANY DAMAGES, INCLUDING, BUT NOT LIMITED TO, DIRECT,
 * INDIRECT, SPECIAL OR CONSEQUENTIAL DAMAGES, ARISING OUT OF, RESULTING FROM, OR
 * IN ANY WAY CONNECTED WITH THIS SOFTWARE, WHETHER OR NOT BASED UPON WARRANTY,
 * CONTRACT, TORT, OR OTHERWISE, WHETHER OR NOT INJURY WAS SUSTAINED BY PERSONS OR
 * PROPERTY OR OTHERWISE, AND WHETHER OR NOT LOSS WAS SUSTAINED FROM, OR AROSE OUT
 * OF THE RESULTS OF, OR USE OF, THE SOFTWARE OR SERVICES PROVIDED HEREUNDER.
 */

package gov.nist.swid.builder;

import java.util.HashMap;
import java.util.Map;

public interface Role {
    Integer getIndex();
    String getName();
    
    static final Map<String, Role> byValueMap = new HashMap<>();

    static final Map<Integer, Role> byIndexMap = new HashMap<>();

    default void init(Integer index, String value) {
        if (index != null) {
            synchronized (byIndexMap) {
                byIndexMap.put(index, this);
            }
        }
        synchronized (byValueMap) {
            byValueMap.put(value, this);
        }
    }

    public static Role assignPrivateRole(int indexValue, String name) {
        Role retval = null;
        synchronized (byValueMap) {
            retval = byValueMap.get(indexValue);
        }
        if (retval == null) {
            retval = new UnknownRole(indexValue, name);
        } else if (retval.getName().equals(name)) {
            // return the current role
        } else {
            throw new IllegalStateException("the role with the name '"+retval.getName()+"' is already assigned to the index value '"+indexValue+"'");
        }
        return retval;
    }

    public static Role lookupByIndex(int value) {
        Role retval = null;
        synchronized (byIndexMap) {
            retval = byIndexMap.get(value);
        }
        return retval;
    }

    public static Role lookupByName(String name) {
        Role retval = null;
        synchronized (byValueMap) {
            retval = byValueMap.get(name);
        }

        if (retval == null) {
            retval = new UnknownRole(name);
        }
        return retval;
    }
}
