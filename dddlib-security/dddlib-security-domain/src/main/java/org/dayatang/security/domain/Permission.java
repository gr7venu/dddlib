package org.dayatang.security.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * 许可基类
 * Created by yyang on 15/1/13.
 */
@Entity
@DiscriminatorValue("PERM")
public class Permission extends Authority {
    protected Permission() {
    }

    public Permission(String name) {
        super(name);
    }

    public static Permission create(String name) {
        Permission permission = new Permission(name);
        permission.save();
        return permission;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 23).append(getName()).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Permission)) {
            return false;
        }
        Permission that = (Permission) other;
        return new EqualsBuilder().append(this.getName(), that.getName()).isEquals();
    }

    @Override
    public String toString() {
        return getName();
    }
}
