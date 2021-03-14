package org.ipo.rwa.reactive.userservice.util;

import org.ipo.rwa.reactive.userservice.bean.AddressBean;
import org.ipo.rwa.reactive.userservice.bean.CompanyBean;
import org.ipo.rwa.reactive.userservice.bean.GeoLocationBean;
import org.ipo.rwa.reactive.userservice.bean.UserBean;
import org.ipo.rwa.reactive.userservice.entity.Address;
import org.ipo.rwa.reactive.userservice.entity.Company;
import org.ipo.rwa.reactive.userservice.entity.GeoLocation;
import org.ipo.rwa.reactive.userservice.entity.User;

import static org.springframework.beans.BeanUtils.copyProperties;

public class BeanUtils {
    public static void copyUserProperties(final UserBean sourceUser, final User targetUser) {
        copyProperties(sourceUser, targetUser);
        if (sourceUser.getAddress() != null) {
            Address targetAddress = new Address();
            copyProperties(sourceUser.getAddress(), targetAddress);
            if (sourceUser.getAddress().getGeoLocation() != null) {
                GeoLocation targetGeoLocation = new GeoLocation();
                copyProperties(sourceUser.getAddress().getGeoLocation(), targetGeoLocation);
                targetAddress.setGeoLocation(targetGeoLocation);
            }
            targetUser.setAddress(targetAddress);
        }

        if (sourceUser.getCompany() != null) {
            Company targetCompany = new Company();
            copyProperties(sourceUser.getCompany(), targetCompany);
            targetUser.setCompany(targetCompany);
        }

    }

    public static void copyUserProperties(final User sourceUser, final UserBean targetUser) {
        copyProperties(sourceUser, targetUser);
        if (sourceUser.getAddress() != null) {
            AddressBean targetAddress = new AddressBean();
            copyProperties(sourceUser.getAddress(), targetAddress);
            if (sourceUser.getAddress().getGeoLocation() != null) {
                GeoLocationBean targetGeoLocation = new GeoLocationBean();
                copyProperties(sourceUser.getAddress().getGeoLocation(), targetGeoLocation);
                targetAddress.setGeoLocation(targetGeoLocation);
            }
            targetUser.setAddress(targetAddress);
        }

        if (sourceUser.getCompany() != null) {
            CompanyBean targetCompany = new CompanyBean();
            copyProperties(sourceUser.getCompany(), targetCompany);
            targetUser.setCompany(targetCompany);
        }

    }
}
