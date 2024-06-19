CREATE TABLE ingredient (
                            ingredient_id SERIAL PRIMARY KEY,
                            name VARCHAR(20) NOT NULL,
                            image_url VARCHAR(100)
);

CREATE TABLE unit (
                      unit_id SERIAL PRIMARY KEY,
                      name VARCHAR(20) NOT NULL
);

CREATE TABLE category (
                          category_id SERIAL PRIMARY KEY,
                          name VARCHAR(20) NOT NULL
);

CREATE TABLE recipe (
                        recipe_id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        category_id INTEGER REFERENCES category(category_id) ON DELETE SET NULL,
                        image_url VARCHAR(255)
);

CREATE TABLE recipe_ingredient (
                                   recipe_id INTEGER REFERENCES recipe(recipe_id) ON DELETE CASCADE,
                                   ingredient_id INTEGER REFERENCES ingredient(ingredient_id) ON DELETE CASCADE,
                                   unit_id INTEGER REFERENCES unit(unit_id) ON DELETE SET NULL,
                                   quantity INTEGER NOT NULL,
                                   PRIMARY KEY (recipe_id, ingredient_id)
);
