package com.await.chinema.da.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<Response> {

    Optional<Response> get(int id);

    List<Response> getAll();

}
