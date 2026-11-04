package tools.seeder.seeds;

import tools.seeder.model.Character;
import tools.seeder.model.enums.Role;

public final class CharacterSeed {
    public static Character[] get(){
        return new Character[]{
                new Character(1, "Asura", Role.Human, 20, "The Ultimate Black hat of Sovaris"),
                new Character(2, "Randel", Role.Ophelian, 22, "The Mad Engineer of Sovaris"),
                new Character(3, "Moriz", Role.Human, 68, "Supreme Ruler of Opelixia"),
                new Character(4, "Reido von Nommaire", Role.Harbinger, 120, "Harbinger of Nommaire"),
                new Character(5, "Apocryptia von Provilis", Role.Harbinger, 132, "Harbinger of Provilis"),
                new Character(6, "Dyranzer", Role.Harbinger, 177, "Supreme Ruler of Suilope"),
                new Character(7, "Roto", Role.Harbinger, 124, "Harbinger of Calystria"),
                new Character(8, "Evarisse", Role.Ophelian, 57, "Akiriyan scholar, Randel's girlfriend")
        };
    }
}
