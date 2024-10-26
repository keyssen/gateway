package com.RViP.gateway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(chain = true)
@Entity
public class Reader {

    @Id
    @GeneratedValue
    @Column(name = "id", updatable = false, columnDefinition = "UUID")
    private UUID id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "phoneNumber", length = 255)
    private String phoneNumber;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "jwt", nullable = false)
    private String jwt;

    public Reader(UUID id, String name, String email, String phoneNumber, Boolean active, String jwt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.active = active;
        this.jwt = jwt;
    }

    public Reader() {
    }

    public static ReaderBuilder builder() {
        return new ReaderBuilder();
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Boolean getActive() {
        return this.active;
    }

    public String getJwt() {
        return this.jwt;
    }

    public Reader setId(UUID id) {
        this.id = id;
        return this;
    }

    public Reader setName(String name) {
        this.name = name;
        return this;
    }

    public Reader setEmail(String email) {
        this.email = email;
        return this;
    }

    public Reader setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Reader setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public Reader setJwt(String jwt) {
        this.jwt = jwt;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Reader)) return false;
        final Reader other = (Reader) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$phoneNumber = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber))
            return false;
        final Object this$active = this.getActive();
        final Object other$active = other.getActive();
        if (this$active == null ? other$active != null : !this$active.equals(other$active)) return false;
        final Object this$jwt = this.getJwt();
        final Object other$jwt = other.getJwt();
        if (this$jwt == null ? other$jwt != null : !this$jwt.equals(other$jwt)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Reader;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        final Object $active = this.getActive();
        result = result * PRIME + ($active == null ? 43 : $active.hashCode());
        final Object $jwt = this.getJwt();
        result = result * PRIME + ($jwt == null ? 43 : $jwt.hashCode());
        return result;
    }

    public String toString() {
        return "Reader(id=" + this.getId() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", phoneNumber=" + this.getPhoneNumber() + ", active=" + this.getActive() + ", jwt=" + this.getJwt() + ")";
    }

    public static class ReaderBuilder {
        private UUID id;
        private String name;
        private String email;
        private String phoneNumber;
        private Boolean active;
        private String jwt;

        ReaderBuilder() {
        }

        public ReaderBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public ReaderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ReaderBuilder email(String email) {
            this.email = email;
            return this;
        }

        public ReaderBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public ReaderBuilder active(Boolean active) {
            this.active = active;
            return this;
        }

        public ReaderBuilder jwt(String jwt) {
            this.jwt = jwt;
            return this;
        }

        public Reader build() {
            return new Reader(this.id, this.name, this.email, this.phoneNumber, this.active, this.jwt);
        }

        public String toString() {
            return "Reader.ReaderBuilder(id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", active=" + this.active + ", jwt=" + this.jwt + ")";
        }
    }
}