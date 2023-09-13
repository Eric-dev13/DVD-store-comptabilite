package com.simplon.dvdstore;

import com.simplon.dvdstore.repositories.DvdStoreRepositoryModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Data
public class DvdStoreModel {
    List<DvdStoreRepositoryModel> dvds = new ArrayList<>();
}
