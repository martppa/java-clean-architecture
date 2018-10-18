package com.martppa.java_clean_way.data.entities.mappers;

import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.entities.TestCountryEntity;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CountryEntityMapperTest extends TestCase {
   private final String
      FAKE_NAME = "Fake name",
      FAKE_CODE = "Fake code",
      FAKE_FLAG = "Fake flag";

   private final int COLLECTION_SIZE = 3;

   private final CountryEntityMapper countryEntityMapper;

   public CountryEntityMapperTest() {
      this.countryEntityMapper = new CountryEntityMapper();
   }

   @Test
   public void testSingleTransform() {
      final int indexCounter = 0;
      CountryEntity countryEntity = createCountryEntity(indexCounter);
      Country transformedCountry = countryEntityMapper.transform(countryEntity);
      Assert.assertEquals(countryEntity.getName(), transformedCountry.getName());
      Assert.assertEquals(countryEntity.getIsoCode(), transformedCountry.getIsoCode());
      Assert.assertEquals(countryEntity.getFlagImageUrl(), transformedCountry.getFlagImageUrl());
   }

   @Test
   public void testCollectionTransform() {
      List<CountryEntity> countryEntityCollection = new ArrayList<CountryEntity>() {{
         add(createCountryEntity(0));
         add(createCountryEntity(1));
         add(createCountryEntity(2));
      }};

      List<Country> transformedCountryCollection
              = countryEntityMapper.transform(countryEntityCollection);

      for (int i = 0; i < COLLECTION_SIZE; i++) {
         Assert.assertEquals(countryEntityCollection.get(i).getName(),
                 transformedCountryCollection.get(i).getName());
         Assert.assertEquals(countryEntityCollection.get(i).getIsoCode(),
                 transformedCountryCollection.get(i).getIsoCode());
         Assert.assertEquals(countryEntityCollection.get(i).getFlagImageUrl(),
                 transformedCountryCollection.get(i).getFlagImageUrl());
      }
   }

   private CountryEntity createCountryEntity(int counter) {
      return new TestCountryEntity(FAKE_NAME + counter,
              FAKE_CODE + counter, FAKE_FLAG + counter);
   }
}