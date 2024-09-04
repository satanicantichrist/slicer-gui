package com.mojang.slicer;

import com.mojang.slicer.commands.BaseCommand;
import com.mojang.slicer.commands.Slice;
import me.satanicantichrist.EasyCli;

import java.util.List;

public class Main {

    private static InputFile move(final String inputPath, final String outputPath) {
        return new InputFile(inputPath).outputs(new OutputFile(outputPath, new Box(0, 0, 1, 1, 1, 1)));
    }

    private static InputFile copyLlama(final String color) {
        final String path = "assets/minecraft/textures/entity/llama/decor/" + color + ".png";
        return move(path, "assets/minecraft/textures/entity/equipment/llama_body/" + color + ".png");
    }

    private static InputFile copy(final String name, final String newName) {
        final String path = "assets/minecraft/textures/" + name + ".png";
        final String newPath = "assets/minecraft/textures/" + newName + ".png";
        return move(path, newPath);
    }

    private static final List<InputFile> INPUTS = List.of(

            //Player
            copy("models/armor/chainmail_layer_1", "entity/equipment/humanoid/chainmail"),
            copy("models/armor/chainmail_layer_2", "entity/equipment/humanoid_leggings/chainmail"),

            copy("models/armor/diamond_layer_1", "entity/equipment/humanoid/diamond"),
            copy("models/armor/diamond_layer_2", "entity/equipment/humanoid_leggings/diamond"),

            copy("models/armor/gold_layer_1", "entity/equipment/humanoid/gold"),
            copy("models/armor/gold_layer_2", "entity/equipment/humanoid_leggings/gold"),

            copy("models/armor/iron_layer_1", "entity/equipment/humanoid/iron"),
            copy("models/armor/iron_layer_2", "entity/equipment/humanoid_leggings/iron"),

            copy("models/armor/leather_layer_1", "entity/equipment/humanoid/leather"),
            copy("models/armor/leather_layer_1_overlay", "entity/equipment/humanoid/leather_overlay"),
            copy("models/armor/leather_layer_2", "entity/equipment/humanoid_leggings/leather"),
            copy("models/armor/leather_layer_2_overlay", "entity/equipment/humanoid_leggings/leather_overlay"),

            copy("models/armor/netherite_layer_1", "entity/equipment/humanoid/netherite"),
            copy("models/armor/netherite_layer_2", "entity/equipment/humanoid_leggings/netherite"),

            copy("models/armor/turtle_layer_1", "entity/equipment/humanoid/turtle_scute"),

            //Horse
            copy("entity/horse/armor/horse_armor_diamond", "entity/equipment/horse_body/diamond"),
            copy("entity/horse/armor/horse_armor_gold", "entity/equipment/horse_body/gold"),
            copy("entity/horse/armor/horse_armor_iron", "entity/equipment/horse_body/iron"),
            copy("entity/horse/armor/horse_armor_leather", "entity/equipment/horse_body/leather"),

            //Llama
            copyLlama("black"),
            copyLlama("blue"),
            copyLlama("brown"),
            copyLlama("cyan"),
            copyLlama("gray"),
            copyLlama("green"),
            copyLlama("light_blue"),
            copyLlama("light_gray"),
            copyLlama("lime"),
            copyLlama("magenta"),
            copyLlama("orange"),
            copyLlama("pink"),
            copyLlama("purple"),
            copyLlama("red"),
            copyLlama("trader_llama"),
            copyLlama("white"),
            copyLlama("yellow"),

            //Wolf
            copy("entity/wolf/wolf_armor", "entity/equipment/wolf_body/armadillo_scute"),
            copy("entity/wolf/wolf_armor_overlay", "entity/equipment/wolf_body/armadillo_scute_overlay"),

            //Elytra
            copy("entity/elytra", "entity/equipment/wings/elytra"),

            //Trims
            copy("trims/models/armor/bolt", "trims/entity/humanoid/bolt"),
            copy("trims/models/armor/bolt_leggings", "trims/entity/humanoid_leggings/bolt"),

            copy("trims/models/armor/coast", "trims/entity/humanoid/coast"),
            copy("trims/models/armor/coast_leggings", "trims/entity/humanoid_leggings/coast"),

            copy("trims/models/armor/dune", "trims/entity/humanoid/dune"),
            copy("trims/models/armor/dune_leggings", "trims/entity/humanoid_leggings/dune"),

            copy("trims/models/armor/eye", "trims/entity/humanoid/eye"),
            copy("trims/models/armor/eye_leggings", "trims/entity/humanoid_leggings/eye"),

            copy("trims/models/armor/flow", "trims/entity/humanoid/flow"),
            copy("trims/models/armor/flow_leggings", "trims/entity/humanoid_leggings/flow"),

            copy("trims/models/armor/host", "trims/entity/humanoid/host"),
            copy("trims/models/armor/host_leggings", "trims/entity/humanoid_leggings/host"),

            copy("trims/models/armor/raiser", "trims/entity/humanoid/raiser"),
            copy("trims/models/armor/raiser_leggings", "trims/entity/humanoid_leggings/raiser"),

            copy("trims/models/armor/rib", "trims/entity/humanoid/rib"),
            copy("trims/models/armor/rib_leggings", "trims/entity/humanoid_leggings/rib"),

            copy("trims/models/armor/sentry", "trims/entity/humanoid/sentry"),
            copy("trims/models/armor/sentry_leggings", "trims/entity/humanoid_leggings/sentry"),

            copy("trims/models/armor/shaper", "trims/entity/humanoid/shaper"),
            copy("trims/models/armor/shaper_leggings", "trims/entity/humanoid_leggings/shaper"),

            copy("trims/models/armor/silence", "trims/entity/humanoid/silence"),
            copy("trims/models/armor/silence_leggings", "trims/entity/humanoid_leggings/silence"),

            copy("trims/models/armor/snout", "trims/entity/humanoid/snout"),
            copy("trims/models/armor/snout_leggings", "trims/entity/humanoid_leggings/snout"),

            copy("trims/models/armor/spire", "trims/entity/humanoid/spire"),
            copy("trims/models/armor/spire_leggings", "trims/entity/humanoid_leggings/spire"),

            copy("trims/models/armor/tide", "trims/entity/humanoid/tide"),
            copy("trims/models/armor/tide_leggings", "trims/entity/humanoid_leggings/tide"),

            copy("trims/models/armor/vex", "trims/entity/humanoid/vex"),
            copy("trims/models/armor/vex_leggings", "trims/entity/humanoid_leggings/vex"),

            copy("trims/models/armor/ward", "trims/entity/humanoid/ward"),
            copy("trims/models/armor/ward_leggings", "trims/entity/humanoid_leggings/ward"),

            copy("trims/models/armor/wayfinder", "trims/entity/humanoid/wayfinder"),
            copy("trims/models/armor/wayfinder_leggings", "trims/entity/humanoid_leggings/wayfinder"),

            copy("trims/models/armor/wild", "trims/entity/humanoid/wild"),
            copy("trims/models/armor/wild_leggings", "trims/entity/humanoid_leggings/wild")
    );

    public static void main(final String[] argv) {
        EasyCli.addCommand(new Slice("1.21.2", INPUTS));
        EasyCli.setBaseCommand(new BaseCommand("1.3.0 for Minecraft 1.21.2"));
        EasyCli.run(argv);
    }
}
