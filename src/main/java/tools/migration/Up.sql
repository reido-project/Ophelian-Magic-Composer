PRAGMA foreign_keys = ON;

-- 1. Magic Class
CREATE TABLE magic_class (
                             id INTEGER PRIMARY KEY AUTOINCREMENT,
                             name TEXT NOT NULL UNIQUE COLLATE NOCASE,
                             created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                             updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 2. Magic Types
CREATE TABLE magic_types (
                             id INTEGER PRIMARY KEY AUTOINCREMENT,
                             magic_class_id INTEGER NOT NULL,
                             name TEXT NOT NULL UNIQUE COLLATE NOCASE,
                             magic_level INTEGER NOT NULL DEFAULT 1 CHECK(magic_level > 0 AND magic_level <= 4),
                             description TEXT,
                             created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                             updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (magic_class_id) REFERENCES magic_class(id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 3. Spells
CREATE TABLE spells (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        magic_type_id INTEGER NOT NULL,
                        name TEXT NOT NULL UNIQUE COLLATE NOCASE,
                        target TEXT NOT NULL,
                        contact INTEGER NOT NULL CHECK(contact IN (0, 1)),
                        short_range INTEGER NOT NULL CHECK(short_range IN (0, 1)),
                        long_range INTEGER NOT NULL CHECK(long_range IN (0, 1)),
                        aoe INTEGER NOT NULL CHECK(aoe IN (0, 1)),
                        minimum_proficiency INTEGER NOT NULL CHECK(minimum_proficiency > 0 AND minimum_proficiency <= 3),
                        cost BIGINT NOT NULL,
                        mechanism TEXT,
                        reference TEXT,
                        created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                        updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (magic_type_id) REFERENCES magic_types(id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 4. Characters
CREATE TABLE characters (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            name TEXT NOT NULL UNIQUE COLLATE NOCASE,
                            role TEXT NOT NULL,
                            age INTEGER CHECK(age >= 0),
                            description TEXT,
                            created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                            updated_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- 5. Character Magic Types
CREATE TABLE character_magic_types (
                                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                                       character_id INTEGER NOT NULL,
                                       magic_type_id INTEGER NOT NULL,
                                       slot TEXT NOT NULL CHECK(slot IN ('primary', 'secondary', 'tertiary')),
                                       proficiency INTEGER NOT NULL CHECK(proficiency > 0 AND proficiency <= 3),
                                       created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                       updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                       FOREIGN KEY (character_id) REFERENCES characters(id) ON UPDATE CASCADE ON DELETE CASCADE,
                                       FOREIGN KEY (magic_type_id) REFERENCES magic_types(id) ON UPDATE CASCADE ON DELETE RESTRICT,
                                       UNIQUE(character_id, slot),
                                       UNIQUE(character_id, magic_type_id)
);

-- 6. Character Spells
CREATE TABLE character_spells (
                                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                                  character_id INTEGER NOT NULL,
                                  spell_id INTEGER NOT NULL,
                                  created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                  FOREIGN KEY (character_id) REFERENCES characters(id) ON UPDATE CASCADE ON DELETE CASCADE,
                                  FOREIGN KEY (spell_id) REFERENCES spells(id) ON UPDATE CASCADE ON DELETE CASCADE,
                                  UNIQUE(character_id, spell_id)
);