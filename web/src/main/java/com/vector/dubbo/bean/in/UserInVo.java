package com.vector.dubbo.bean.in;

import lombok.Data;

/**
 * @author smq
 */
@Data
public class UserInVo {
    private String name;
    private String passWord;
    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof UserInVo)) {
            return false;
        } else {
            UserInVo other = (UserInVo)o;
            if (!(other instanceof UserInVo)) {
                return false;
            } else {
                Object thisName = this.getName();
                Object otherName = other.getName();
                if (thisName == null) {
                    if (otherName != null) {
                        return false;
                    }
                } else if (!thisName.equals(otherName)) {
                    return false;
                }

                Object thisPassWord = this.getPassWord();
                Object otherPassWord = other.getPassWord();
                if (thisPassWord == null) {
                    if (otherPassWord != null) {
                        return false;
                    }
                } else if (!thisPassWord.equals(otherPassWord)) {
                    return false;
                }

                return true;
            }
        }
    }
    @Override
    public int hashCode() {
        // int PRIME = true;
        int result = 1;
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $passWord = this.getPassWord();
        result = result * 59 + ($passWord == null ? 43 : $passWord.hashCode());
        return result;
    }
}
