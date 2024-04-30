package com.example.pranksounds.data.repositories

import android.content.Context
import com.example.pranksounds.R
import com.example.pranksounds.data.models.SoundItem

class SoundsListRepo {

    companion object {

        fun getSoundsList(context: Context, categoryId: Int): List<SoundItem> {
            val soundsList = ArrayList<SoundItem>()

            when (categoryId) {
                0/*Fart*/ -> {
                    soundsList.add(
                        SoundItem(
                            0,
                            context.getString(R.string.fart_1)!!,
                            context.getColor(R.color.color_1),
                            "fart_1.mp3",
                            R.drawable.ic_fart
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            1,
                            context.getString(R.string.fart_2), context.getColor(R.color.color_2), "fart_2.mp3",
                            R.drawable.ic_fart
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            2,
                            context.getString(R.string.fart_3), context.getColor(R.color.color_3), "fart_3.mp3",
                            R.drawable.ic_fart
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            3,
                            context.getString(R.string.fart_4), context.getColor(R.color.color_4), "fart_4.mp3",
                            R.drawable.ic_fart
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            4,
                            context.getString(R.string.fart_5), context.getColor(R.color.color_5), "fart_5.mp3",
                            R.drawable.ic_fart
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            5,
                            context.getString(R.string.fart_6), context.getColor(R.color.color_6), "fart_6.mp3",
                            R.drawable.ic_fart
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            6,
                            context.getString(R.string.fart_7), context.getColor(R.color.color_7), "fart_7.mp3",
                            R.drawable.ic_fart
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            7,
                            context.getString(R.string.fart_8), context.getColor(R.color.color_8), "fart_8.mp3",
                            R.drawable.ic_fart
                        )
                    )
                }

                1/*Scary*/ -> {
                    soundsList.add(
                        SoundItem(
                            8,
                            context.getString(R.string.scary_1), context.getColor(R.color.color_1), "scary_1.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            9,
                            context.getString(R.string.scary_2), context.getColor(R.color.color_2), "scary_2.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            10,
                            context.getString(R.string.scary_3), context.getColor(R.color.color_3), "scary_3.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            11,
                            context.getString(R.string.scary_4), context.getColor(R.color.color_4), "scary_4.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            12,
                            context.getString(R.string.scary_5), context.getColor(R.color.color_5), "scary_5.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            13,
                            context.getString(R.string.scary_6), context.getColor(R.color.color_6), "scary_6.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            14,
                            context.getString(R.string.scary_7), context.getColor(R.color.color_7), "scary_7.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            15,
                            context.getString(R.string.scary_8), context.getColor(R.color.color_8), "scary_8.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            16,
                            context.getString(R.string.scary_9), context.getColor(R.color.color_9), "scary_9.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            17,
                            context.getString(R.string.scary_10), context.getColor(R.color.color_10), "scary_10.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            18,
                            context.getString(R.string.scary_11), context.getColor(R.color.color_11), "scary_11.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            19,
                            context.getString(R.string.scary_12), context.getColor(R.color.color_12), "scary_12.mp3",
                            R.drawable.ic_scary
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            20,
                            context.getString(R.string.scary_13), context.getColor(R.color.color_13), "scary_13.mp3",
                            R.drawable.ic_scary
                        )
                    )
                }

                2/*Trimmer*/ -> {
                    soundsList.add(
                        SoundItem(
                            21,
                            context.getString(R.string.trimmer_1), context.getColor(R.color.color_1), "trimmer_1.mp3",
                            R.drawable.ic_trimmer
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            22,
                            context.getString(R.string.trimmer_2), context.getColor(R.color.color_2), "trimmer_2.mp3",
                            R.drawable.ic_trimmer
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            23,
                            context.getString(R.string.trimmer_3), context.getColor(R.color.color_3), "trimmer_3.mp3",
                            R.drawable.ic_trimmer
                        )
                    )
                }

                3/*Flushing*/ -> {
                    soundsList.add(
                        SoundItem(
                            24,
                            context.getString(R.string.flushing_1), context.getColor(R.color.color_1), "flushing_1.mp3",
                            R.drawable.ic_flushing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            25,
                            context.getString(R.string.flushing_2), context.getColor(R.color.color_2), "flushing_2.mp3",
                            R.drawable.ic_flushing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            26,
                            context.getString(R.string.flushing_3), context.getColor(R.color.color_3), "flushing_3.mp3",
                            R.drawable.ic_flushing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            27,
                            context.getString(R.string.flushing_4), context.getColor(R.color.color_4), "flushing_4.mp3",
                            R.drawable.ic_flushing
                        )
                    )
                }

                4/*Gun*/ -> {
                    soundsList.add(
                        SoundItem(
                            28,
                            context.getString(R.string.gun_1), context.getColor(R.color.color_1), "gun_1.mp3",
                            R.drawable.ic_gun
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            29,
                            context.getString(R.string.gun_2), context.getColor(R.color.color_2), "gun_2.mp3",
                            R.drawable.ic_gun
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            30,
                            context.getString(R.string.gun_3), context.getColor(R.color.color_3), "gun_3.mp3",
                            R.drawable.ic_gun
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            31,
                            context.getString(R.string.gun_4), context.getColor(R.color.color_4), "gun_4.mp3",
                            R.drawable.ic_gun
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            32,
                            context.getString(R.string.gun_5), context.getColor(R.color.color_5), "gun_5.mp3",
                            R.drawable.ic_gun
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            33,
                            context.getString(R.string.gun_6), context.getColor(R.color.color_6), "gun_6.mp3",
                            R.drawable.ic_gun
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            34,
                            context.getString(R.string.gun_7), context.getColor(R.color.color_7), "gun_7.mp3",
                            R.drawable.ic_gun
                        )
                    )
                }

                5/*Air Horn*/ -> {
                    soundsList.add(
                        SoundItem(
                            35,
                            context.getString(R.string.air_horn_1), context.getColor(R.color.color_1), "air_horn_1.mp3",
                            R.drawable.ic_air_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            36,
                            context.getString(R.string.air_horn_2), context.getColor(R.color.color_2), "air_horn_2.mp3",
                            R.drawable.ic_air_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            37,
                            context.getString(R.string.air_horn_3), context.getColor(R.color.color_3), "air_horn_3.mp3",
                            R.drawable.ic_air_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            38,
                            context.getString(R.string.air_horn_4), context.getColor(R.color.color_4), "air_horn_4.mp3",
                            R.drawable.ic_air_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            39,
                            context.getString(R.string.air_horn_5), context.getColor(R.color.color_5), "air_horn_5.mp3",
                            R.drawable.ic_air_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            40,
                            context.getString(R.string.air_horn_6), context.getColor(R.color.color_6), "air_horn_6.mp3",
                            R.drawable.ic_air_horn
                        )
                    )
                }

                6/*Dog*/ -> {
                    soundsList.add(
                        SoundItem(
                            41,
                            context.getString(R.string.dog_1), context.getColor(R.color.color_1), "dog_1.mp3",
                            R.drawable.ic_dog_barking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            42,
                            context.getString(R.string.dog_2), context.getColor(R.color.color_2), "dog_2.mp3",
                            R.drawable.ic_dog_barking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            43,
                            context.getString(R.string.dog_3), context.getColor(R.color.color_3), "dog_3.mp3",
                            R.drawable.ic_dog_barking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            44,
                            context.getString(R.string.dog_4), context.getColor(R.color.color_4), "dog_4.mp3",
                            R.drawable.ic_dog_barking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            45,
                            context.getString(R.string.dog_5), context.getColor(R.color.color_5), "dog_5.mp3",
                            R.drawable.ic_dog_barking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            46,
                            context.getString(R.string.dog_6), context.getColor(R.color.color_6), "dog_6.mp3",
                            R.drawable.ic_dog_barking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            47,
                            context.getString(R.string.dog_7), context.getColor(R.color.color_7), "dog_7.mp3",
                            R.drawable.ic_dog_barking
                        )
                    )
                }

                7/*Breaking*/ -> {
                    soundsList.add(
                        SoundItem(
                            48,
                            context.getString(R.string.breaking_1), context.getColor(R.color.color_1), "breaking_1.mp3",
                            R.drawable.ic_breaking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            49,
                            context.getString(R.string.breaking_2), context.getColor(R.color.color_2), "breaking_2.mp3",
                            R.drawable.ic_breaking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            50,
                            context.getString(R.string.breaking_3), context.getColor(R.color.color_3), "breaking_3.mp3",
                            R.drawable.ic_breaking
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            51,
                            context.getString(R.string.breaking_4), context.getColor(R.color.color_4), "breaking_4.mp3",
                            R.drawable.ic_breaking
                        )
                    )
                }

                8/*Car Horn*/ -> {
                    soundsList.add(
                        SoundItem(
                            52,
                            context.getString(R.string.car_horn_1), context.getColor(R.color.color_1), "car_horn_1.mp3",
                            R.drawable.ic_car_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            53,
                            context.getString(R.string.car_horn_2), context.getColor(R.color.color_2), "car_horn_2.mp3",
                            R.drawable.ic_car_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            54,
                            context.getString(R.string.car_horn_3), context.getColor(R.color.color_3), "car_horn_3.mp3",
                            R.drawable.ic_car_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            55,
                            context.getString(R.string.car_horn_4), context.getColor(R.color.color_4), "car_horn_4.mp3",
                            R.drawable.ic_car_horn
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            56,
                            context.getString(R.string.car_horn_5), context.getColor(R.color.color_5), "car_horn_5.mp3",
                            R.drawable.ic_car_horn
                        )
                    )
                }

                9/*Burp Sounds*/ -> {
                    soundsList.add(
                        SoundItem(
                            57,
                            context.getString(R.string.burp_1), context.getColor(R.color.color_1), "burp_1.mp3",
                            R.drawable.ic_burp
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            58,
                            context.getString(R.string.burp_2), context.getColor(R.color.color_2), "burp_2.mp3",
                            R.drawable.ic_burp
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            59,
                            context.getString(R.string.burp_3), context.getColor(R.color.color_3), "burp_3.mp3",
                            R.drawable.ic_burp
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            60,
                            context.getString(R.string.burp_4), context.getColor(R.color.color_4), "burp_4.mp3",
                            R.drawable.ic_burp
                        )
                    )
                }

                10/*Creaking Door*/ -> {
                    soundsList.add(
                        SoundItem(
                            61,
                            context.getString(R.string.creaking_1),
                            context.getColor(R.color.color_1),
                            "creaking_door_1.mp3",
                            R.drawable.ic_creaking_door
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            62,
                            context.getString(R.string.creaking_2),
                            context.getColor(R.color.color_2),
                            "creaking_door_2.mp3",
                            R.drawable.ic_creaking_door
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            63,
                            context.getString(R.string.creaking_3),
                            context.getColor(R.color.color_3),
                            "creaking_door_3.mp3",
                            R.drawable.ic_creaking_door
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            64,
                            context.getString(R.string.creaking_4),
                            context.getColor(R.color.color_4),
                            "creaking_door_4.mp3",
                            R.drawable.ic_creaking_door
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            65,
                            context.getString(R.string.creaking_5),
                            context.getColor(R.color.color_5),
                            "creaking_door_5.mp3",
                            R.drawable.ic_creaking_door
                        )
                    )
                }

                11/*Snoring*/ -> {
                    soundsList.add(
                        SoundItem(
                            66,
                            context.getString(R.string.snoring_1), context.getColor(R.color.color_1), "snoring_1.mp3",
                            R.drawable.ic_snoring
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            67,
                            context.getString(R.string.snoring_2), context.getColor(R.color.color_2), "snoring_2.mp3",
                            R.drawable.ic_snoring
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            68,
                            context.getString(R.string.snoring_3), context.getColor(R.color.color_3), "snoring_3.mp3",
                            R.drawable.ic_snoring
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            69,
                            context.getString(R.string.snoring_4), context.getColor(R.color.color_4), "snoring_4.mp3",
                            R.drawable.ic_snoring
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            70,
                            context.getString(R.string.snoring_5), context.getColor(R.color.color_5), "snoring_5.mp3",
                            R.drawable.ic_snoring
                        )
                    )
                }

                12/*Whistle*/ -> {
                    soundsList.add(
                        SoundItem(
                            71,
                            context.getString(R.string.whistle_1), context.getColor(R.color.color_1), "whistle_1.mp3",
                            R.drawable.ic_whistle
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            72,
                            context.getString(R.string.whistle_2), context.getColor(R.color.color_2), "whistle_2.mp3",
                            R.drawable.ic_whistle
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            73,
                            context.getString(R.string.whistle_3), context.getColor(R.color.color_3), "whistle_3.mp3",
                            R.drawable.ic_whistle
                        )
                    )
                }

                13/*Police Siren*/ -> {
                    soundsList.add(
                        SoundItem(
                            74,
                            context.getString(R.string.siren_1), context.getColor(R.color.color_1), "police_siren_1.mp3",
                            R.drawable.ic_police_siren
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            75,
                            context.getString(R.string.siren_2), context.getColor(R.color.color_2), "police_siren_2.mp3",
                            R.drawable.ic_police_siren
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            76,
                            context.getString(R.string.siren_3), context.getColor(R.color.color_3), "police_siren_3.mp3",
                            R.drawable.ic_police_siren
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            77,
                            context.getString(R.string.siren_4), context.getColor(R.color.color_4), "police_siren_4.mp3",
                            R.drawable.ic_police_siren
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            78,
                            context.getString(R.string.siren_5), context.getColor(R.color.color_5), "police_siren_5.mp3",
                            R.drawable.ic_police_siren
                        )
                    )
                }

                14/*Doorbell*/ -> {
                    soundsList.add(
                        SoundItem(
                            79,
                            context.getString(R.string.door_bell_1),
                            context.getColor(R.color.color_1),
                            "door_bell_1.mp3",
                            R.drawable.ic_door_bell
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            80,
                            context.getString(R.string.door_bell_2),
                            context.getColor(R.color.color_2),
                            "door_bell_2.mp3",
                            R.drawable.ic_door_bell
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            81,
                            context.getString(R.string.door_bell_3),
                            context.getColor(R.color.color_3),
                            "door_bell_3.mp3",
                            R.drawable.ic_door_bell
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            82,
                            context.getString(R.string.door_bell_4),
                            context.getColor(R.color.color_4),
                            "door_bell_4.mp3",
                            R.drawable.ic_door_bell
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            83,
                            context.getString(R.string.door_bell_5),
                            context.getColor(R.color.color_5),
                            "door_bell_5.mp3",
                            R.drawable.ic_door_bell
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            84,
                            context.getString(R.string.door_bell_6),
                            context.getColor(R.color.color_6),
                            "door_bell_6.mp3",
                            R.drawable.ic_door_bell
                        )
                    )
                }

                15/*Crying Baby*/ -> {
                    soundsList.add(
                        SoundItem(
                            85,
                            context.getString(R.string.crying_baby_1),
                            context.getColor(R.color.color_1),
                            "baby_crying_1.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            86,
                            context.getString(R.string.crying_baby_2),
                            context.getColor(R.color.color_2),
                            "baby_crying_2.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            87,
                            context.getString(R.string.crying_baby_3),
                            context.getColor(R.color.color_3),
                            "baby_crying_3.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            88,
                            context.getString(R.string.crying_baby_4),
                            context.getColor(R.color.color_4),
                            "baby_crying_4.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            89,
                            context.getString(R.string.crying_baby_5),
                            context.getColor(R.color.color_5),
                            "baby_crying_5.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            90,
                            context.getString(R.string.crying_baby_6),
                            context.getColor(R.color.color_6),
                            "baby_crying_6.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            91,
                            context.getString(R.string.crying_baby_7),
                            context.getColor(R.color.color_7),
                            "baby_crying_7.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            92,
                            context.getString(R.string.crying_baby_8),
                            context.getColor(R.color.color_8),
                            "baby_crying_8.mp3",
                            R.drawable.ic_baby_crying
                        )
                    )
                }

                16/*Crying man*/ -> {
                    soundsList.add(
                        SoundItem(
                            93,
                            context.getString(R.string.crying_man_1),
                            context.getColor(R.color.color_1),
                            "man_crying_1.mp3",
                            R.drawable.ic_man_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            94,
                            context.getString(R.string.crying_man_2),
                            context.getColor(R.color.color_2),
                            "man_crying_2.mp3",
                            R.drawable.ic_man_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            95,
                            context.getString(R.string.crying_man_3),
                            context.getColor(R.color.color_3),
                            "man_crying_3.mp3",
                            R.drawable.ic_man_crying
                        )
                    )
                }

                17/*Crying Woman*/ -> {
                    soundsList.add(
                        SoundItem(
                            96,
                            context.getString(R.string.crying_woman_1),
                            context.getColor(R.color.color_1),
                            "woman_crying_1.mp3",
                            R.drawable.ic_woman_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            97,
                            context.getString(R.string.crying_woman_2),
                            context.getColor(R.color.color_2),
                            "woman_crying_2.mp3",
                            R.drawable.ic_woman_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            98,
                            context.getString(R.string.crying_woman_3),
                            context.getColor(R.color.color_3),
                            "woman_crying_3.mp3",
                            R.drawable.ic_woman_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            99,
                            context.getString(R.string.crying_woman_4),
                            context.getColor(R.color.color_4),
                            "woman_crying_4.mp3",
                            R.drawable.ic_woman_crying
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            100,
                            context.getString(R.string.crying_woman_5),
                            context.getColor(R.color.color_5),
                            "woman_crying_5.mp3",
                            R.drawable.ic_woman_crying
                        )
                    )
                }

                18/*Man Sneeze*/ -> {
                    soundsList.add(
                        SoundItem(
                            101,
                            context.getString(R.string.sneeze_1),
                            context.getColor(R.color.color_1),
                            "man_sneeze_1.mp3",
                            R.drawable.ic_man_sneeze
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            102,
                            context.getString(R.string.sneeze_2),
                            context.getColor(R.color.color_2),
                            "man_sneeze_2.mp3",
                            R.drawable.ic_man_sneeze
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            103,
                            context.getString(R.string.sneeze_3),
                            context.getColor(R.color.color_3),
                            "man_sneeze_3.mp3",
                            R.drawable.ic_man_sneeze
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            104,
                            context.getString(R.string.sneeze_4),
                            context.getColor(R.color.color_4),
                            "man_sneeze_4.mp3",
                            R.drawable.ic_man_sneeze
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            105,
                            context.getString(R.string.sneeze_5),
                            context.getColor(R.color.color_5),
                            "man_sneeze_5.mp3",
                            R.drawable.ic_man_sneeze
                        )
                    )
                }

                19/*Woman Sneeze*/ -> {
                    soundsList.add(
                        SoundItem(
                            106,
                            context.getString(R.string.sneeze_1),
                            context.getColor(R.color.color_1),
                            "woman_sneeze_1.mp3",
                            R.drawable.ic_woman_sneeze
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            107,
                            context.getString(R.string.sneeze_2),
                            context.getColor(R.color.color_2),
                            "woman_sneeze_2.mp3",
                            R.drawable.ic_woman_sneeze
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            108,
                            context.getString(R.string.sneeze_3),
                            context.getColor(R.color.color_3),
                            "woman_sneeze_3.mp3",
                            R.drawable.ic_woman_sneeze
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            109,
                            context.getString(R.string.sneeze_4),
                            context.getColor(R.color.color_4),
                            "woman_sneeze_4.mp3",
                            R.drawable.ic_woman_sneeze
                        )
                    )
                }

                20/*Baby Sneeze*/ -> {
                    soundsList.add(
                        SoundItem(
                            110,
                            context.getString(R.string.sneeze_1),
                            context.getColor(R.color.color_1),
                            "baby_sneeze_1.mp3",
                            R.drawable.ic_baby_sneeze
                        )
                    )
                }

                21/*Laughing Man*/ -> {
                    soundsList.add(
                        SoundItem(
                            111,
                            context.getString(R.string.man_laugh_1),
                            context.getColor(R.color.color_1),
                            "man_laugh_1.mp3",
                            R.drawable.ic_man_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            112,
                            context.getString(R.string.man_laugh_2),
                            context.getColor(R.color.color_2),
                            "man_laugh_2.mp3",
                            R.drawable.ic_man_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            113,
                            context.getString(R.string.man_laugh_3),
                            context.getColor(R.color.color_3),
                            "man_laugh_3.mp3",
                            R.drawable.ic_man_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            114,
                            context.getString(R.string.man_laugh_4),
                            context.getColor(R.color.color_4),
                            "man_laugh_4.mp3",
                            R.drawable.ic_man_laughing
                        )
                    )
                }

                22/*Laughing Woman*/ -> {
                    soundsList.add(
                        SoundItem(
                            115,
                            context.getString(R.string.laugh_1),
                            context.getColor(R.color.color_1),
                            "woman_laugh_1.mp3",
                            R.drawable.ic_woman_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            116,
                            context.getString(R.string.laugh_2),
                            context.getColor(R.color.color_2),
                            "woman_laugh_2.mp3",
                            R.drawable.ic_woman_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            117,
                            context.getString(R.string.laugh_3),
                            context.getColor(R.color.color_3),
                            "woman_laugh_3.mp3",
                            R.drawable.ic_woman_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            118,
                            context.getString(R.string.laugh_4),
                            context.getColor(R.color.color_4),
                            "woman_laugh_4.mp3",
                            R.drawable.ic_woman_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            119,
                            context.getString(R.string.laugh_5),
                            context.getColor(R.color.color_5),
                            "woman_laugh_5.mp3",
                            R.drawable.ic_woman_laughing
                        )
                    )
                }

                23/*Laughing Baby*/ -> {
                    soundsList.add(
                        SoundItem(
                            120,
                            context.getString(R.string.baby_laugh_1),
                            context.getColor(R.color.color_1),
                            "baby_laugh_1.mp3",
                            R.drawable.ic_baby_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            121,
                            context.getString(R.string.baby_laugh_2),
                            context.getColor(R.color.color_2),
                            "baby_laugh_2.mp3",
                            R.drawable.ic_baby_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            122,
                            context.getString(R.string.baby_laugh_3),
                            context.getColor(R.color.color_3),
                            "baby_laugh_3.mp3",
                            R.drawable.ic_baby_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            123,
                            context.getString(R.string.baby_laugh_4),
                            context.getColor(R.color.color_4),
                            "baby_laugh_4.mp3",
                            R.drawable.ic_baby_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            124,
                            context.getString(R.string.baby_laugh_5),
                            context.getColor(R.color.color_5),
                            "baby_laugh_5.mp3",
                            R.drawable.ic_baby_laughing
                        )
                    )
                    soundsList.add(
                        SoundItem(
                            125,
                            context.getString(R.string.baby_laugh_6),
                            context.getColor(R.color.color_6),
                            "baby_laugh_6.mp3",
                            R.drawable.ic_baby_laughing
                        )
                    )
                }
            }

            return soundsList
        }
    }
}