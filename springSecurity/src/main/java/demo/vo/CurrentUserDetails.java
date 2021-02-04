package demo.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author LiaoQinZhou
 * @date: 2021/2/4 16:58
 */
public class CurrentUserDetails extends User implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getPermissions().stream()
                .filter(permission -> Objects.nonNull(permission) && Objects.nonNull(permission.getId()))
                .map(permission -> new SimpleGrantedAuthority(permission.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
