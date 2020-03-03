//package com.github.lebw.tacocloud.repository;
//
//import com.github.lebw.tacocloud.domain.Ingredient;
//import com.github.lebw.tacocloud.domain.Taco;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.sql.Timestamp;
//import java.sql.Types;
//import java.util.Arrays;
//import java.util.Date;
//
///**
// * @author LBW
// */
////@Repository
//public class JdbcTacoRepository implements TacoRepository {
//
//    @Autowired
//    private JdbcTemplate jdbc;
//    @Override
//    public Taco save(Taco taco) {
//        long tacoId = saveTacoInfo(taco);
//        taco.setId(tacoId);
//        for (Ingredient ingredient: taco.getIngredients()) {
//            saveIngredientToTaco(ingredient.getId(), tacoId);
//        }
//
//        return taco;
//    }
//
//    private void saveIngredientToTaco(String ingredientId, long tacoId) {
//        jdbc.update(
//                "insert into Taco_Ingredients (taco, ingredient) " + "values (?, ?)",
//                tacoId, ingredientId);
//    }
//
//    private long saveTacoInfo(Taco taco) {
//        taco.setCreateAt(new Date());
//
//        PreparedStatementCreatorFactory factory =
//                new PreparedStatementCreatorFactory(
//                        "insert into Taco(name, createdAt) values (?, ?)",
//                        Types.VARCHAR, Types.TIMESTAMP
//                );
//        factory.setReturnGeneratedKeys(true);
//
//        PreparedStatementCreator psc = factory.newPreparedStatementCreator(
//                        Arrays.asList(
//                                taco.getName(),
//                                new Timestamp(taco.getCreateAt().getTime())));
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbc.update(psc, keyHolder);
//
//        return keyHolder.getKey().longValue();
//    }
//}
