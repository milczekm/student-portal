package com.students.dao;

import com.students.model.Address;
import java.util.List;

public interface AddressDAO {

    List<Address> findAllAddresses();
}
