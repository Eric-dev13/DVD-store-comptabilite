package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class DvdStoreModel {
    List<DvdStoreRepositoryModel> dvds = new ArrayList<>();
}
