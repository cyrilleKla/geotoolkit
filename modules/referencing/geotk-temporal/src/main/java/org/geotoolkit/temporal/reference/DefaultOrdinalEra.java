/*
 *    Geotoolkit - An Open Source Java GIS Toolkit
 *    http://www.geotoolkit.org
 * 
 *    (C) 2008, Open Source Geospatial Foundation (OSGeo)
 *    (C) 2009, Geomatys
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotoolkit.temporal.reference;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import org.opengis.temporal.OrdinalEra;
import org.opengis.util.InternationalString;

/**
 *
 * @author Mehdi Sidhoum (Geomatys)
 * @module pending
 */
public class DefaultOrdinalEra implements OrdinalEra {

    /**
     * This is a string that identifies the ordinal era within the TM_OrdinalReferenceSystem.
     */
    private InternationalString name;
    /**
     * This is the temporal position at which the ordinal era began, if it is known.
     */
    private Date beginning;
    /**
     * This is the temporal position at which the ordinal era ended.
     */
    private Date end;
    private Collection<OrdinalEra> composition;
    private DefaultOrdinalEra group;

    public DefaultOrdinalEra(final InternationalString name, final Date beginning, final Date end) {
        if (! beginning.before(end))
            throw new IllegalArgumentException("The beginning date of the OrdinalEra must be less than (i.e. earlier than) the end date of this OrdinalEra.");
        this.name = name;
        this.beginning = beginning;
        this.end = end;
    }

    public DefaultOrdinalEra(final InternationalString name, final Date beginning, final Date end, final Collection<OrdinalEra> composition) {
        this.name = name;
        this.beginning = beginning;
        this.end = end;

        for (OrdinalEra ordinalEra : composition) {
            ((DefaultOrdinalEra) ordinalEra).setGroup(this);
        }
    }

    public InternationalString getName() {
        return name;
    }

    public Date getBeginning() {
        return beginning;
    }

    public Date getEnd() {
        return end;
    }

    public Collection<OrdinalEra> getComposition() {
        return composition;
    }

    public void setName(final InternationalString name) {
        this.name = name;
    }

    public void setBeginning(final Date beginning) {
        this.beginning = beginning;
    }

    public void setEnd(final Date end) {
        this.end = end;
    }

    public DefaultOrdinalEra getGroup() {
        return group;
    }

    public void setGroup(final DefaultOrdinalEra group) {
        this.group = group;
    }

    @Override
    public boolean equals(final Object object) {
        if (object instanceof DefaultOrdinalEra) {
            final DefaultOrdinalEra that = (DefaultOrdinalEra) object;

            return Objects.equals(this.beginning, that.beginning) &&
                    Objects.equals(this.end, that.end) &&
                    Objects.equals(this.composition, that.composition) &&
                    Objects.equals(this.group, that.group) &&
                    Objects.equals(this.name, that.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.beginning != null ? this.beginning.hashCode() : 0);
        hash = 37 * hash + (this.end != null ? this.end.hashCode() : 0);
        hash = 37 * hash + (this.composition != null ? this.composition.hashCode() : 0);
        hash = 37 * hash + (this.group != null ? this.group.hashCode() : 0);
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("OrdinalEra:").append('\n');
        if (name != null) {
            s.append("name:").append(name).append('\n');
        }
        if (beginning != null) {
            s.append("beginning:").append(beginning).append('\n');
        }
        if (end != null) {
            s.append("end:").append(end).append('\n');
        }
        if (composition != null) {
            s.append("composition:").append(composition).append('\n');
        }
        if (group != null) {
            s.append("group:").append(group).append('\n');
        }
        return s.toString();
    }
}