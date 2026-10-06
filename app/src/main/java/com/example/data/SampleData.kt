package com.example.data

import com.example.model.*

object SampleData {

    // --- VOCABULARY DATABASE ---
    val vocabularies: List<VocabularyWord> = listOf(
        // Greetings & Etiquette
        VocabularyWord(
            id = "v_jwajalapa",
            wordNewa = "ज्वजलपा",
            phonetic = "Jwajalapā",
            nepaliMeaning = "नमस्ते / नमस्कार",
            englishMeaning = "Greetings / Hello (traditional polite greeting)",
            category = VocabCategory.GREETINGS,
            partOfSpeech = "Interjection",
            honorificNote = "Used with folded hands (Anjali Mudra) to all ages",
            exampleNewa = "ज्वजलपा, छिगु नां छु खः?",
            exampleNepali = "नमस्ते, तपाईंको नाम के हो?",
            exampleEnglish = "Greetings, what is your name?"
        ),
        VocabularyWord(
            id = "v_bhintuna",
            wordNewa = "भिंतुना",
            phonetic = "Bhintunā",
            nepaliMeaning = "शुभकामना",
            englishMeaning = "Best wishes / Congratulations / Blessings",
            category = VocabCategory.GREETINGS,
            partOfSpeech = "Noun",
            honorificNote = "Commonly used in 'न्हुदँया भिंतुना' (Happy New Year)",
            exampleNewa = "नेपाल संवत् ११४६ या भिंतुना!",
            exampleNepali = "नेपाल संवत् ११४६ को शुभकामना!",
            exampleEnglish = "Warm wishes for Nepal Sambat 1146!"
        ),
        VocabularyWord(
            id = "v_subhay",
            wordNewa = "सुभाय्",
            phonetic = "Subhāy",
            nepaliMeaning = "धन्यवाद",
            englishMeaning = "Thank you",
            category = VocabCategory.GREETINGS,
            partOfSpeech = "Interjection",
            honorificNote = "Expresses gratitude in both casual and formal contexts",
            exampleNewa = "छिंत तसकं सुभाय् दु।",
            exampleNepali = "तपाईंलाई धेरै धन्यवाद छ।",
            exampleEnglish = "Thank you very much."
        ),
        VocabularyWord(
            id = "v_laskus",
            wordNewa = "लसकुस",
            phonetic = "Laskus",
            nepaliMeaning = "स्वागत / स्वागतम्",
            englishMeaning = "Welcome / Auspicious Reception",
            category = VocabCategory.GREETINGS,
            partOfSpeech = "Noun",
            honorificNote = "Traditional ceremonial welcome with vermilion and flower garland",
            exampleNewa = "झीगु छेँय् सकसितं लसकुस दु।",
            exampleNepali = "हाम्रो घरमा सबैलाई स्वागत छ।",
            exampleEnglish = "Everyone is welcome to our home."
        ),
        VocabularyWord(
            id = "v_cha_chhi",
            wordNewa = "छि / वय्कः",
            phonetic = "Chhi / Vayka",
            nepaliMeaning = "तपाईं / उहाँ (आदरार्थी)",
            englishMeaning = "You (respectful) / He, She (honorific)",
            category = VocabCategory.GREETINGS,
            partOfSpeech = "Pronoun",
            honorificNote = "Never use 'छ' (Cha) for elders; always use 'छि' (Chhi)",
            exampleNewa = "छि गन झायादीगु?",
            exampleNepali = "तपाईं कहाँ जान लाग्नुभएको?",
            exampleEnglish = "Where are you going, sir/madam?"
        ),

        // Food & Culinary
        VocabularyWord(
            id = "v_samaybaji",
            wordNewa = "समोयबजि",
            phonetic = "Samaybaji",
            nepaliMeaning = "समयबजी (परम्परागत नेवारी खाजा)",
            englishMeaning = "Traditional Newari auspicious platter (beaten rice, black soybeans, choila, ginger, boiled egg, aila)",
            category = VocabCategory.FOOD,
            partOfSpeech = "Noun",
            honorificNote = "Sacred prasad served at religious ceremonies and pujas",
            exampleNewa = "कन्हय् नखःया दिं समोयबजि नया जुइ।",
            exampleNepali = "भोलि चाडको दिन समयबजी खाएर रमाइलो गरिनेछ।",
            exampleEnglish = "Tomorrow on the festive day, we will relish Samaybaji."
        ),
        VocabularyWord(
            id = "v_yomari",
            wordNewa = "योमरि",
            phonetic = "Yomari",
            nepaliMeaning = "योमरी (चामलको पीठो र चाकु-खुवाको विशेष परिकार)",
            englishMeaning = "Steamed rice-flour pastry filled with chaku (jaggery) and sesame or khuwa",
            category = VocabCategory.FOOD,
            partOfSpeech = "Noun",
            honorificNote = "'यो' means favorite/liked, 'मरि' means bread/delicacy",
            exampleNewa = "योमरि पुन्हिबलय् चाकु तयाः योमरि दयेकी।",
            exampleNepali = "योमरी पूर्णिमामा चाकु राखेर योमरी बनाइन्छ।",
            exampleEnglish = "On Yomari Punhi, sweet yomari is prepared with jaggery filling."
        ),
        VocabularyWord(
            id = "v_chatamari",
            wordNewa = "चटामरि",
            phonetic = "Chatāmari",
            nepaliMeaning = "चटामरी (नेवारी चामलको पिज्जा/रोटी)",
            englishMeaning = "Crispy rice-flour crepe topped with minced meat, eggs, or vegetables",
            category = VocabCategory.FOOD,
            partOfSpeech = "Noun",
            honorificNote = "Known famously as the 'Newari pizza'",
            exampleNewa = "येँया दबुली बांलाःगु चटामरि दयेकी।",
            exampleNepali = "काठमाडौँको डबलीमा स्वादिष्ट चटामरी बनाइन्छ।",
            exampleEnglish = "Delicious chatamari is prepared at the Kathmandu square."
        ),
        VocabularyWord(
            id = "v_woh",
            wordNewa = "वो",
            phonetic = "Woh (Bara)",
            nepaliMeaning = "बारा (दालको मस्यौरा/रोटी)",
            englishMeaning = "Savory spiced lentil patty/cake",
            category = VocabCategory.FOOD,
            partOfSpeech = "Noun",
            honorificNote = "Prepared with black gram (Māsh) or green moong lentils",
            exampleNewa = "खेँय् तयाः दयेकूगु वो तसकं साः।",
            exampleNepali = "अन्डा राखेर बनाएको बारा धेरै मिठो हुन्छ।",
            exampleEnglish = "Lentil patty made with egg is very tasty."
        ),
        VocabularyWord(
            id = "v_aila",
            wordNewa = "ऐला",
            phonetic = "Ailā",
            nepaliMeaning = "ऐला (परम्परागत नेवारी मदिरा)",
            englishMeaning = "Potent traditional distilled rice or millet spirit",
            category = VocabCategory.FOOD,
            partOfSpeech = "Noun",
            honorificNote = "Poured gracefully from an anti vessel during feasts",
            exampleNewa = "भोय्‌बलय् आदरपूर्वक ऐला ल्हाइ।",
            exampleNepali = "भोजमा आदरपूर्वक ऐला पस्कन्छन्।",
            exampleEnglish = "During feasts, Aila is poured with deep hospitality."
        ),

        // Family & Kinship
        VocabularyWord(
            id = "v_ba",
            wordNewa = "बा / अबु",
            phonetic = "Bā / Abu",
            nepaliMeaning = "बुबा / पिता",
            englishMeaning = "Father",
            category = VocabCategory.FAMILY,
            partOfSpeech = "Noun",
            honorificNote = "Honorific term: 'अजी' or 'बाःजु'",
            exampleNewa = "जिमि बा ज्याकुथिइ झायादिल।",
            exampleNepali = "मेरो बुबा कार्यालय जानुभयो।",
            exampleEnglish = "My father went to the office."
        ),
        VocabularyWord(
            id = "v_ma",
            wordNewa = "मां",
            phonetic = "Mān",
            nepaliMeaning = "आमा / माता",
            englishMeaning = "Mother",
            category = VocabCategory.FAMILY,
            partOfSpeech = "Noun",
            honorificNote = "Worshiped on 'मांया ख्वाः स्वयेगु' (Mother's Day)",
            exampleNewa = "जिमि मां तसकं मतिना यानादी।",
            exampleNepali = "मेरी आमा धेरै माया गर्नुहुन्छ।",
            exampleEnglish = "My mother loves me dearly."
        ),
        VocabularyWord(
            id = "v_kija",
            wordNewa = "किजा",
            phonetic = "Kijā",
            nepaliMeaning = "भाइ",
            englishMeaning = "Younger Brother",
            category = VocabCategory.FAMILY,
            partOfSpeech = "Noun",
            honorificNote = "Celebrated on 'किजा पूजा' (Bhai Tika)",
            exampleNewa = "किजा पूजाबलय् तातां भिंतुना बियादिल।",
            exampleNepali = "भाइटीकामा दिदीले आशिष् दिनुभयो।",
            exampleEnglish = "On Kija Puja, elder sister gave blessings."
        ),
        VocabularyWord(
            id = "v_tata",
            wordNewa = "ताता",
            phonetic = "Tātā",
            nepaliMeaning = "दिदी",
            englishMeaning = "Elder Sister",
            category = VocabCategory.FAMILY,
            partOfSpeech = "Noun",
            honorificNote = "Affectionate term of high respect",
            exampleNewa = "जिमि ताता तसकं ज्ञानी जुयादी।",
            exampleNepali = "मेरी दिदी धेरै ज्ञानी हुनुहुन्छ।",
            exampleEnglish = "My elder sister is very wise."
        ),
        VocabularyWord(
            id = "v_pasa",
            wordNewa = "पासा",
            phonetic = "Pāsā",
            nepaliMeaning = "साथी / मित्र",
            englishMeaning = "Friend / Companion",
            category = VocabCategory.FAMILY,
            partOfSpeech = "Noun",
            honorificNote = "'सद्भावपूर्ण पासा' denotes true friend",
            exampleNewa = "जि व जिमि पासा ब्वनेकुथिइ नापलाना।",
            exampleNepali = "म र मेरो साथी विद्यालयमा भेटियौँ।",
            exampleEnglish = "My friend and I met at school."
        ),

        // Numbers & Time
        VocabularyWord(
            id = "v_chhi",
            wordNewa = "छि (छगु)",
            phonetic = "Chhi (Chhagu)",
            nepaliMeaning = "एक (१)",
            englishMeaning = "One (1)",
            category = VocabCategory.NUMBERS,
            partOfSpeech = "Numeral",
            honorificNote = "Base count unit in Nepal Bhasa",
            exampleNewa = "जिन्त छगु सफू माल।",
            exampleNepali = "मलाई एउटा किताब चाहियो।",
            exampleEnglish = "I need one book."
        ),
        VocabularyWord(
            id = "v_nasi",
            wordNewa = "नसि (निगु)",
            phonetic = "Nasi (Nigu)",
            nepaliMeaning = "दुई (२)",
            englishMeaning = "Two (2)",
            category = VocabCategory.NUMBERS,
            partOfSpeech = "Numeral",
            honorificNote = "Two items count",
            exampleNewa = "निगु चटामरि बियादिसँ।",
            exampleNepali = "दुईवटा चटामरी दिनुहोस्।",
            exampleEnglish = "Please give two chatamaris."
        ),
        VocabularyWord(
            id = "v_swa",
            wordNewa = "स्व (स्वंगु)",
            phonetic = "Swa (Swangu)",
            nepaliMeaning = "तीन (३)",
            englishMeaning = "Three (3)",
            category = VocabCategory.NUMBERS,
            partOfSpeech = "Numeral",
            honorificNote = "Three items count",
            exampleNewa = "स्वंगु देसय् नेपाल भाषा ल्हाइ।",
            exampleNepali = "तीन देशमा नेपाल भाषा बोलिन्छ।",
            exampleEnglish = "Nepal Bhasa is spoken across three nations."
        ),
        VocabularyWord(
            id = "v_pi",
            wordNewa = "पि (प्यंगु)",
            phonetic = "Pi (Pyangu)",
            nepaliMeaning = "चार (४)",
            englishMeaning = "Four (4)",
            category = VocabCategory.NUMBERS,
            partOfSpeech = "Numeral",
            honorificNote = "Signifies four directions (प्यंगू कुं)",
            exampleNewa = "प्यंगु नगरय् जात्रा जुइ।",
            exampleNepali = "चार नगरमा जात्रा हुन्छ।",
            exampleEnglish = "Festivals take place across the four cities."
        ),
        VocabularyWord(
            id = "v_nya",
            wordNewa = "न्या (न्यागु)",
            phonetic = "Nyā (Nyāgu)",
            nepaliMeaning = "पाँच (५)",
            englishMeaning = "Five (5)",
            category = VocabCategory.NUMBERS,
            partOfSpeech = "Numeral",
            honorificNote = "Panchabuddha / Panchatattva sacred number",
            exampleNewa = "न्याम्ह दाजुकिजा दक्वं ज्ञानी खः।",
            exampleNepali = "पाँचै भाइहरू सबै ज्ञानी छन्।",
            exampleEnglish = "All five brothers are virtuous."
        ),
        VocabularyWord(
            id = "v_jhi",
            wordNewa = "झी (झिगु)",
            phonetic = "Jhi (Jhigu)",
            nepaliMeaning = "दश (१०)",
            englishMeaning = "Ten (10)",
            category = VocabCategory.NUMBERS,
            partOfSpeech = "Numeral",
            honorificNote = "Signifies completion of decimal set",
            exampleNewa = "झिद्वः मनूत जात्राय् वल।",
            exampleNepali = "दश हजार मानिसहरू जात्रामा आए।",
            exampleEnglish = "Ten thousand people gathered at the festival."
        ),

        // Verbs & Actions
        VocabularyWord(
            id = "v_wanegu",
            wordNewa = "वनेगु",
            phonetic = "Wanegu",
            nepaliMeaning = "जानु",
            englishMeaning = "To go",
            category = VocabCategory.VERBS,
            partOfSpeech = "Verb",
            honorificNote = "Honorific form: झायादीगु (Jhayadigu)",
            exampleNewa = "जि जात्रा स्वयेत वना।",
            exampleNepali = "म जात्रा हेर्न गएँ।",
            exampleEnglish = "I went to observe the festival."
        ),
        VocabularyWord(
            id = "v_wayegu",
            wordNewa = "वयेगु",
            phonetic = "Wayegu",
            nepaliMeaning = "आउनु",
            englishMeaning = "To come",
            category = VocabCategory.VERBS,
            partOfSpeech = "Verb",
            honorificNote = "Honorific form: झायादीगु (Jhayadigu)",
            exampleNewa = "छि कन्हय् जिमि छेँय् वा।",
            exampleNepali = "तपाईं भोलि मेरो घर आउनुहोस्।",
            exampleEnglish = "Please come to my home tomorrow."
        ),
        VocabularyWord(
            id = "v_nayegu",
            wordNewa = "नयेगु",
            phonetic = "Nayegu",
            nepaliMeaning = "खानु",
            englishMeaning = "To eat",
            category = VocabCategory.VERBS,
            partOfSpeech = "Verb",
            honorificNote = "Honorific form: नयादीगु / नलादीगु",
            exampleNewa = "छि जा नया धुन ला?",
            exampleNepali = "तपाईंले भात खाइसक्नुभयो?",
            exampleEnglish = "Have you eaten your meal?"
        ),
        VocabularyWord(
            id = "v_lhayegu",
            wordNewa = "ल्हायेगु",
            phonetic = "Lhāyegu",
            nepaliMeaning = "बोल्नु / कुरा गर्नु",
            englishMeaning = "To speak / converse",
            category = VocabCategory.VERBS,
            partOfSpeech = "Verb",
            honorificNote = "Root word of app 'Lha' (ल्हा)",
            exampleNewa = "झीसं नेपाल भाषा ल्हाये माः।",
            exampleNepali = "हामीले नेपाल भाषा बोल्नुपर्छ।",
            exampleEnglish = "We must speak Nepal Bhasa."
        ),

        // Culture & Heritage
        VocabularyWord(
            id = "v_guthi",
            wordNewa = "गुथि",
            phonetic = "Guthi",
            nepaliMeaning = "गुठी (सामाजिक र धार्मिक संस्था)",
            englishMeaning = "Guthi (traditional community socioeconomic socio-religious institution of Newars)",
            category = VocabCategory.CULTURE,
            partOfSpeech = "Noun",
            honorificNote = "Preserves temples, dances, water ponds, funeral rites, and heritage",
            exampleNewa = "गुथि व्यवस्थां झीगु सम्पदा म्वाका तःगु दु।",
            exampleNepali = "गुठी व्यवस्थाले हाम्रो सम्पदा जीवित राखेको छ।",
            exampleEnglish = "The Guthi system keeps our living heritage alive."
        ),
        VocabularyWord(
            id = "v_mhapuja",
            wordNewa = "म्हा पूजा",
            phonetic = "Mhā Pujā",
            nepaliMeaning = "म्हा पूजा (आत्म पूजा)",
            englishMeaning = "Worship of the Self / Soul on Nepal Sambat New Year day",
            category = VocabCategory.CULTURE,
            partOfSpeech = "Noun",
            honorificNote = "Celebrates spiritual purity and inner divinity with oil mandala (Manda:)",
            exampleNewa = "न्हुदँया दिं म्हा पूजा यानाः मन्दः च्वइ।",
            exampleNepali = "नयाँ वर्षको दिन म्हा पूजा गरेर मण्डल बनाइन्छ।",
            exampleEnglish = "On New Year's day, Mha Puja is performed with sacred mandalas."
        ),
        VocabularyWord(
            id = "v_lakhey",
            wordNewa = "लाखे",
            phonetic = "Lākhey",
            nepaliMeaning = "लाखे (रक्षक दैत्य/नाच)",
            englishMeaning = "Majipa Lakhey (protective demon deity and legendary masked dance of Kathmandu)",
            category = VocabCategory.CULTURE,
            partOfSpeech = "Noun",
            honorificNote = "Dances through the streets during Indra Jatra accompanied by Dhimay drums",
            exampleNewa = "येँयाः पुन्हिबलय् मजिपाः लाखे हुला वइ।",
            exampleNepali = "इन्द्रजात्रा पूर्णिमामा मजीपा लाखे नाचेर आउँछ।",
            exampleEnglish = "During Indra Jatra, the Majipa Lakhey performs with ferocious grace."
        ),

        // Idioms & Cultural Proverbs (खँत्वाः)
        VocabularyWord(
            id = "v_khantwa1",
            wordNewa = "नसा म्वाःसा भ्वाः, खँ म्वाःसा ल्वाः",
            phonetic = "Nasā mwāsā bhwā:, khã mwāsā lwā:",
            nepaliMeaning = "धेरै खाए मोटो, धेरै बोले झगडा",
            englishMeaning = "Excessive eating makes one corpulent; excessive words provoke dispute (Speak with moderation)",
            category = VocabCategory.IDIOMS,
            partOfSpeech = "Proverb",
            honorificNote = "Classic moral proverb on speech prudence",
            exampleNewa = "खँ ल्हायेबलय् होस तयेमाः: नसा म्वाःसा भ्वाः, खँ म्वाःसा ल्वाः।",
            exampleNepali = "कुरा गर्दा ध्यान दिनुपर्छ: धेरै खाए मोटो, धेरै बोले झगडा।",
            exampleEnglish = "Be mindful when speaking: excess food fattens, excess talk quarrels."
        ),
        VocabularyWord(
            id = "v_khantwa2",
            wordNewa = "मनू सियाः नां ल्यनी, सिमा सिनाः सि ल्यनी",
            phonetic = "Manū siyā: nān lyani, simā sinā: si lyani",
            nepaliMeaning = "मान्छे मरेर नाम रहन्छ, रुख सुकेर काठ रहन्छ",
            englishMeaning = "A human departs leaving behind good reputation, just as a fallen tree leaves timber",
            category = VocabCategory.IDIOMS,
            partOfSpeech = "Proverb",
            honorificNote = "Teaches nobility of character and lasting legacy",
            exampleNewa = "बांलाःगु ज्या यायेमाः, मनू सियाः नां ल्यनी।",
            exampleNepali = "राम्रो काम गर्नुपर्छ, मान्छे मरेर नाम बाँकी रहन्छ।",
            exampleEnglish = "Do noble deeds, for human lives pass but honored names endure."
        )
    )

    // --- NEWS ARTICLES (TRI-LINGUAL) ---
    val newsArticles: List<NewsArticle> = listOf(
        NewsArticle(
            id = "news_1",
            category = NewsCategory.CULTURE,
            title = LocalizedString(
                newa = "नेपाल संवत् ११४६ न्हुदँ राष्ट्रिय गौरवया रुपं हनेगु बृहत् तयारी",
                nepali = "नेपाल संवत् ११४६ नयाँ वर्ष राष्ट्रिय गौरवका रूपमा मनाउने बृहत् तयारी",
                english = "Grand preparations to celebrate Nepal Sambat 1146 New Year as National Pride Festival"
            ),
            subtitle = LocalizedString(
                newa = "शंखधर साख्वाया योगदानयात लुमंकाः येँ, यल व ख्वपय् भिंतुना र्‍याली जुइ",
                nepali = "शंखधर साख्वाको योगदान स्मरण गर्दै काठमाडौँ, ललितपुर र भक्तपुरमा भिन्तुना र्‍याली निकालिने",
                english = "Bhintuna cultural rallies across Kathmandu, Patan & Bhaktapur honoring Shankhadhar Sakhwa"
            ),
            content = LocalizedString(
                newa = """
                    नेपाल संवत् ११४६ या न्हुदँ (न्हुगु दँ) थुगुसी भव्य रुपं हनेगु निंतिं येँ, यल व ख्वप स्वंगुलिं ऐतिहासिक नगरय् तयारी तीब्र जूगु दु। राष्ट्रिय विभूति शंखधर साख्वां गरिब जनताया त्यासा (ऋण) मोचन यानाः थ्व संवत् न्ह्याकादीगु खः।
                    
                    न्हुदँया लसताय् न्हिल्याः कछलाथ्व पारु कुन्हु म्हा पूजा यानाः सकल छेँजः जानाः भिंतुना कालबिल याइ। थुगुसीया र्‍यालीइ पारम्परिक धिमे, धाः, भुस्याः बाजागाजा व लाखे नाचया नापं नेपाल भाषाया साहित्यिक झाँकी प्रदर्शन यायेगु तयारी समितिं न्ह्यब्वःगु दु।
                    
                    सम्पदाविद्तय्सं नेपाल संवत् नेपाःया मौलिक राष्ट्रिय संवत् जूगुलिं थुकियात सरकारी दस्तावेज व डिजिटल माध्यमय् व्यापक रुपं प्रयोगय् हयेमाःगु माग तःगु दु।
                """.trimIndent(),
                nepali = """
                    नेपाल संवत् ११४६ को नयाँ वर्ष यस पटक भव्य रूपमा मनाउन काठमाडौँ, ललितपुर र भक्तपुर तीनवटै ऐतिहासिक सहरमा तयारी तीव्र पारिएको छ। राष्ट्रिय विभूति शंखधर साख्वाले गरिब जनताको ऋण मोचन गरी यो मौलिक संवत् सुरुवात गर्नुभएको थियो।
                    
                    नयाँ वर्षको उपलक्ष्यमा कछलाथ्व पारुको दिन म्हा पूजा गरेर सम्पूर्ण परिवार एकसाथ भई शुभकामना आदानप्रदान गरिन्छ। यसपालिको भिन्तुना र्‍यालीमा परम्परागत धिमे बाजा, धाः बाजा, भुस्याः र लाखे नाचका साथै नेपाल भाषाको साहित्यिक झाँकी प्रदर्शन गर्ने तयारी गरिएको छ।
                    
                    सम्पदाविद्हरूले नेपाल संवत् नेपालको आफ्नै मौलिक राष्ट्रिय संवत् भएकाले यसलाई सरकारी कामकाज र डिजिटल माध्यममा व्यापक प्रयोग गर्नुपर्ने माग राखेका छन्।
                """.trimIndent(),
                english = """
                    Preparations are underway across the three historic cities of Kathmandu, Patan, and Bhaktapur to celebrate the auspicious Nepal Sambat 1146 New Year with grandeur. This unique era was established by national hero Shankhadhar Sakhwa by liberating all citizens from debt.
                    
                    The festivities coincide with Mha Puja (Worship of the Self) on the first day of Kachhala month, where families unite to exchange cordial Bhintuna blessings. The celebratory procession will feature vibrant Dhimay and Dhaa drums, bronze cymbals, legendary Lakhey dances, and Nepal Bhasa cultural pageants.
                    
                    Heritage advocates reiterated that Nepal Sambat, as the sovereign indigenous calendar of the soil, deserves comprehensive institutional integration in government documentation and digital platforms.
                """.trimIndent()
            ),
            gregorianDate = "Oct 2026",
            sambatDate = "कछलाथ्व पारु ११४६",
            readTimeMinutes = 3,
            author = "सुवर्ण शाक्य (Subarna Shakya)",
            keyVocabIds = listOf("v_bhintuna", "v_mhapuja", "v_guthi", "v_lakhey"),
            iconEmoji = "🏮"
        ),
        NewsArticle(
            id = "news_2",
            category = NewsCategory.HERITAGE,
            title = LocalizedString(
                newa = "गुथि व्यवस्था व नेवाः जलसम्पदा: सिथि नखःया न्हापांगु संकल्प",
                nepali = "गुठी व्यवस्था र नेवाः जलसम्पदा: सिथि नखःको ऐतिहासिक संकल्प",
                english = "Guthi System and Traditional Water Heritage: The Sacred Pledge of Sithi Nakha"
            ),
            subtitle = LocalizedString(
                newa = "न्हूगु पुस्तां त्वाःत्वालय् च्वंगु तुं, ल्वहँहिति व पुखू सफा यायेगु अभियान न्ह्याकल",
                nepali = "नयाँ पुस्ताद्वारा टोलटोलका इनार, ढुङ्गेधारा र पोखरी सरसफाइ अभियान सुरु",
                english = "Youth groups lead conservation of historic stone spouts (Hiti), traditional wells, and ponds"
            ),
            content = LocalizedString(
                newa = """
                    येँ देय्या पुलांगु बस्तीइ च्वंगु ल्वहँहिति, तुं (इनार) व पुखू संरक्षण यायेगु निंतिं स्थानीय गुथित जानाः न्हुगु अभियान सुरु याःगु दु। नेवाः संस्कृतिय् सिथि नखःयात जलस्रोत सफा यायेगु दकलय् तःधंगु पर्वया रुपं हनेगु याइ।
                    
                    उपत्यकाया १०० स्वयां अप्वः पुलांगु ढुङ्गेधारा आः नं म्वाका तयेमाःगु व राजकुलो व्यवस्थायात पुनर्जीवन बीमाःगु सम्पदा संरक्षणकर्मीतय्सं धाःगु दु। थ्व अभियानं प्राचीन इन्जिनियरिङया अद्भुत नमूनायात संरक्षण यायेत ग्वाहालि याइ।
                    
                    स्थानीय युवातय्सं वइगु पुन्हिबलय् सांस्कृतिक कार्यशाला व भाषा कक्षा सञ्चालन यानाः सम्पदाया महत्व न्ह्यब्वइगु क्वःछिउगु दु।
                """.trimIndent(),
                nepali = """
                    काठमाडौँ उपत्यकाका पुराना बस्तीमा रहेका ढुङ्गेधारा, इनार र पोखरी संरक्षणका लागि स्थानीय गुठीहरू मिलेर नयाँ अभियान सुरु गरेका छन्। नेवार संस्कृतिमा सिथि नखःलाई जलस्रोत सरसफाइ गर्ने सबैभन्दा पवित्र पर्व मानिन्छ।
                    
                    उपत्यकाका १०० भन्दा बढी ऐतिहासिक ढुङ्गेधाराहरूलाई अझै पनि जीवित राख्न राजकुलो प्रणालीलाई पुनर्जीवित गर्नुपर्ने सम्पदाविद्हरूको भनाइ छ। यस अभियानले प्राचीन इन्जिनियरिङको अद्भुत नमुना जोगाउन ठूलो मद्दत पुर्‍याउनेछ।
                    
                    स्थानीय युवाहरूले आगामी पूर्णिमामा सांस्कृतिक कार्यशाला र नेपाल भाषा कक्षा सञ्चालन गरी मौलिक सम्पदाको महत्त्व उजागर गर्ने निर्णय गरेका छन्।
                """.trimIndent(),
                english = """
                    Local Guthis across the Kathmandu Valley have united to launch an urgent revitalization campaign for historical stone water spouts (Lwonhiti), wells (Tun), and reservoir ponds (Pukhu). In Newar culture, the festival of Sithi Nakha stands as an ancestral environmental tradition dedicated to water sanctification.
                    
                    Heritage engineers highlighted the need to restore the ancient Rajkulo canal channels that nourish over 100 historical spouts. This ecological wisdom reflects the pinnacle of medieval hydraulic engineering.
                    
                    Youth volunteers also announced upcoming cultural seminars and Nepal Bhasa workshops to educate future generations on indigenous sustainable town planning.
                """.trimIndent()
            ),
            gregorianDate = "Sep 2026",
            sambatDate = "तछलाथ्व ११४६",
            readTimeMinutes = 4,
            author = "सृष्टि मानन्धर (Sristi Manandhar)",
            keyVocabIds = listOf("v_guthi", "v_laskus", "v_pasa"),
            iconEmoji = "🏛️"
        ),
        NewsArticle(
            id = "news_3",
            category = NewsCategory.LITERATURE,
            title = LocalizedString(
                newa = "नेपाल भाषा व रञ्जना लिपिया डिजिटलाइजेसन: मोबाइल एपय् प्राचीन लिपि",
                nepali = "नेपाल भाषा र रञ्जना लिपिको डिजिटलाइजेसन: मोबाइल एपमा प्राचीन लिपि",
                english = "Digitalization of Nepal Bhasa & Ranjana Script: Ancient Calligraphy Enters Mobile Apps"
            ),
            subtitle = LocalizedString(
                newa = "युनिकोड स्ट्याण्डर्ड व फन्ट प्रविधिं यानाः हलिमय् नेपाल भाषा सयेकेगु अःपु जुल",
                nepali = "युनिकोड मानक र आधुनिक फन्ट प्रविधिले विश्वभर नेपाल भाषा सिक्न सहज",
                english = "Unicode standards and font utilities make learning Nepal Bhasa accessible worldwide"
            ),
            content = LocalizedString(
                newa = """
                    सयौं दँ पुलांगु ताडपत्र, थ्यासफू व शिलालेखय् च्वयातःगु नेपाल भाषाया रञ्जना व प्रचलित लिपियात आधुनिक कम्प्युटर प्रविधिइ हयेगु ज्याय् तःधंगु सफलता मिले जूगु दु।
                    
                    न्हूगु मोबाइल एप व फन्टया माध्यमं विद्यार्थी व अनुसन्धानकर्ता तय्सं अःपुक थ्व लिपि सयेके फइगु जूगु दु। नेपाल लिपि गुथि व भाषाप्रेमी तय्सं डिजिटलाइजेसनं यानाः दुर्लभ सफूत सुरक्षित जूगु खँ न्ह्यब्वःगु दु।
                    
                    विदेशय् च्वनाच्वंपिं नेवाःतय्सं नं थ्व एपपाखें थः मस्तय्त नेपाल भाषा ल्हायेगु व च्वयेगु स्यने फइगु जूगुलिं लसता प्वंकूगु दु।
                """.trimIndent(),
                nepali = """
                    सयौँ वर्ष पुराना ताडपत्र, थ्यासफू (परम्परागत पुस्तक) र शिलालेखमा कुँदिएका नेपाल भाषाका रञ्जना तथा प्रचलित लिपिलाई आधुनिक कम्प्युटर प्रविधिमा रूपान्तरण गर्ने कार्यमा उल्लेख्य सफलता मिलेको छ।
                    
                    नयाँ मोबाइल एप र फन्टको माध्यमबाट विद्यार्थी तथा अनुसन्धानकर्ताहरूले सजिलै यो लिपि सिक्न सक्नेछन्। नेपाल लिपि गुठी तथा भाषासेवीहरूले डिजिटलाइजेसनका कारण दुर्लभ पाण्डुलिपिहरू भविष्यका लागि सुरक्षित भएको बताएका छन्।
                    
                    विदेशमा बसोबास गर्ने नेपालीहरूले पनि आफ्ना बालबालिकालाई घरमै बसेर मातृभाषा बोल्न र लेख्न सिकाउन सकिने भन्दै खुसी व्यक्त गरेका छन्।
                """.trimIndent(),
                english = """
                    Decades of preservation efforts have reached a watershed milestone as historic Nepal Bhasa manuscripts—inscribed on palm-leaf Thyasaphu codices and temple stone steles in Ranjana and Prachalit scripts—are systematically digitalized.
                    
                    With standardized Unicode fonts and interactive mobile learning platforms, scholars and aspiring learners worldwide can now study the scripts effortlessly. The Nepal Lipi Guthi noted that digital conservation ensures fragile manuscripts are permanently shielded from degradation.
                    
                    Diaspora families highlighted that mobile-first language apps empower younger generations born abroad to speak, write, and treasure their ancestral tongue.
                """.trimIndent()
            ),
            gregorianDate = "Aug 2026",
            sambatDate = "गुंलागाः ११४६",
            readTimeMinutes = 3,
            author = "अनिल महर्जन (Anil Maharjan)",
            keyVocabIds = listOf("v_subhay", "v_lhayegu"),
            iconEmoji = "📜"
        ),
        NewsArticle(
            id = "news_4",
            category = NewsCategory.CULTURE,
            title = LocalizedString(
                newa = "योमरि पुन्हिया नसा व स्वास्थ्य: परम्परागत नेवाः विज्ञान",
                nepali = "योमरी पूर्णिमाको परिकार र स्वास्थ्य: परम्परागत नेवार विज्ञान",
                english = "Culinary & Health Science of Yomari: Winter Nutrition in Traditional Newar Lore"
            ),
            subtitle = LocalizedString(
                newa = "चिकुलाया इलय् चामलया पिठो, चाकु व तिलं म्हयात क्वाकः तइ",
                nepali = "जाडो मौसममा चामलको पिठो, चाकु र तिलले शरीरलाई न्यानो राख्ने वैज्ञानिक आधार",
                english = "Scientific harmony of rice flour, jaggery molasses and sesame seeds for winter immunity"
            ),
            content = LocalizedString(
                newa = """
                    नेवाः संस्कृतिय् नसा केवल नसा जक मखु, थ्व ऋतुअनुसारया प्राकृतिक चिकित्सा खः। थिंला पुन्हि कुन्हु हनेगु योमरि पुन्हिबलय् चाकु, तिल, व खुवा तयाः योमरि दयेकी।
                    
                    चिकित्सकतय्सं धाःगु दु कि चिकुलाया इलय् चाकु व तिलं म्हयात आवश्यक क्यालोरी व शक्ति बी, गुकिं यानाः चिसो मौसमय् रोग प्रतिरोधात्मक क्षमता अप्वइ। न्हुगु बालीया चामलया पिठों योमरि दयेकेगु परम्परां किसानतय्त सम्मान नं न्ह्यब्वइ।
                    
                    थ्व दिं म्येँ हालिगु परम्परा 'त्यःछिं त्यः बकसि त्यः' हालसें मस्त छेँखा-छेँखाय् वनाः योमरि फ्वनेगु सांस्कृतिक रमाइलो नं जुइ।
                """.trimIndent(),
                nepali = """
                    नेवार संस्कृतिमा भोजन केवल स्वाद मात्र नभई ऋतु अनुसारको प्राकृतिक औषधि विज्ञान हो। थिंला पूर्णिमाको दिन मनाइने योमरी पूर्णिमामा चाकु, तिल र खुवा भरेर योमरी पकाइन्छ।
                    
                    आयुर्वेद विज्ञहरूका अनुसार चिसो मौसममा चाकु र तिलले शरीरलाई आवश्यक ऊर्जा प्रदान गर्दछ, जसले रुघाखोकी र चिसोबाट बचाउँछ। नयाँ धानको चामलको पिठोबाट योमरी बनाउने चलनले कृषकप्रति कृतज्ञता समेत व्यक्त गर्दछ।
                    
                    यस दिन 'त्यःछिं त्यः बकसि त्यः' भन्दै बालबालिका घरघर गई योमरी माग्ने पुरानो सांस्कृतिक परम्परा अझै पनि जीवन्त छ।
                """.trimIndent(),
                english = """
                    In Newar civilization, gastronomy is intertwined with seasonal preventive medicine. Celebrated during the chilly full moon of Thinla, Yomari pastries are delicately stuffed with molten molasses (Chaku), toasted sesame, and dairy khuwa.
                    
                    Nutritionists explain that jaggery and sesame provide vital thermogenic calories and minerals, shielding the body against winter ailments. Preparing Yomari using the virgin harvest of newly reaped rice grain also symbolizes thanksgiving to mother earth and agrarian toil.
                    
                    The festival is also cherished for the merry folk tradition where neighborhood youth sing the beloved rhyme 'Tyochhin Tyo, Bakasi Tyo', collecting freshly steamed treats from door to door.
                """.trimIndent()
            ),
            gregorianDate = "Dec 2026",
            sambatDate = "थिंलाथ्व पुन्हि ११४६",
            readTimeMinutes = 4,
            author = "रोशन वज्राचार्य (Roshan Vajracharya)",
            keyVocabIds = listOf("v_yomari", "v_samaybaji", "v_nayegu"),
            iconEmoji = "🥟"
        ),
        NewsArticle(
            id = "news_5",
            category = NewsCategory.VALLEY,
            title = LocalizedString(
                newa = "ख्वप (भक्तपुर) या दबुली त्वाःत्वालय् धिमे बाजा व बाँसुरी प्रशिक्षण",
                nepali = "भक्तपुरको डबलीमा टोलटोलमा धिमे बाजा र बाँसुरी प्रशिक्षण तीव्र",
                english = "Rhythmic Awakening: Dhimay Drum & Bamboo Flute Ensembles Train in Bhaktapur Dabali"
            ),
            subtitle = LocalizedString(
                newa = "मिसा व मिजं ल्याय्म्ह तय्सं तःधंगु उत्साहपूर्वक बाजा सयेकेगु ज्याझ्वलय् ब्वति काल",
                nepali = "महिला तथा पुरुष युवाहरूले परम्परागत बाजा सिक्ने कार्यशालामा लिए उत्साहजनक सहभागिता",
                english = "Young men and women enthusiastically embrace sacred percussion & melody instruments"
            ),
            content = LocalizedString(
                newa = """
                    ऐतिहासिक नगर ख्वप (भक्तपुर) या थीथी दबुली (सांस्कृतिक मञ्च) य् धिमे बाजा, बाँसुरी व ताः बाजा सयेकेगु सछिन्हुया ज्याझ्वः सुरु जूगु दु। 
                    
                    थ्व ज्याझ्वलय् मिसा ल्याय्म्हतय्सं नं बांलाःगु ब्वति कयाच्वंगु दु। न्हापा मिजंतय्सं जक धिमे थायेगु चलन दूगु जुसां आः मिसातय्सं नं बाजा थायेगु, लाखे हुलेगु व सांस्कृतिक ध्वाँय ज्वनेगु ज्याय् न्ह्यचिलाच्वंगु दु।
                    
                    गुरुतय्सं थ्व प्रशिक्षणं नेवाः पहिचान व बाजा संस्कृतियात पुस्तान्तरण यायेत तःधंगु बल बीगु विश्वास प्वंकूगु दु।
                """.trimIndent(),
                nepali = """
                    ऐतिहासिक नगर भक्तपुरका विभिन्न डबलीहरूमा धिमे बाजा, बाँसुरी र ताः बाजा सिकाउने १०० दिने प्रशिक्षण सुरु भएको छ।
                    
                    यस कार्यक्रममा महिलाहरूको सहभागिता उल्लेखनीय रहेको छ। विगतमा पुरुषहरूले मात्र धिमे बजाउने चलन रहे पनि हाल युवतीहरूले पनि बाजा बजाउने, लाखे नाच्ने र सांस्कृतिक अगुवाइ गर्ने कार्यमा सक्रियता देखाएका छन्।
                    
                    स्थानीय गुरुहरूले यस किसिमको तालिमले मौलिक संगीत र सम्पदा भावी पुस्तामा हस्तान्तरण गर्न महत्त्वपूर्ण योगदान पुर्‍याउने बताएका छन्।
                """.trimIndent(),
                english = """
                    A 100-day masterclass series in traditional Dhimay drums, Bansuri bamboo flutes, and Taa cymbals has commenced across the historic Dabali stone platforms of Bhaktapur.
                    
                    A remarkable feature is the surging participation of young women. While Dhimay drumming was historically dominated by men, women are now proudly leading ensembles, playing intricate rhythms, and performing ceremonial masked dances.
                    
                    Master instructors affirmed that grassroots community training is the most resilient shield to ensure indigenous musical heritage is passed down dynamically.
                """.trimIndent()
            ),
            gregorianDate = "Jul 2026",
            sambatDate = "दिल्लाथ्व ११४६",
            readTimeMinutes = 3,
            author = "प्रविण कर्माचार्य (Prawin Karmacharya)",
            keyVocabIds = listOf("v_jwajalapa", "v_pasa", "v_subhay"),
            iconEmoji = "🥁"
        )
    )

    // --- LESSON UNITS (STRUCTURED LEARNING PATHWAY) ---
    val lessonUnits: List<LessonUnit> = listOf(
        LessonUnit(
            id = "unit_1",
            unitNumber = 1,
            title = LocalizedString("न्हापांगु पलाः: ज्वजलपा व शिष्टाचार", "पहिलो कदम: अभिवादन र शिष्टाचार", "First Steps: Greetings & Etiquette"),
            description = LocalizedString("ज्वजलपा, भिंतुना, लसकुस व आधारभूत शिष्टाचार खँग्वः सयेकेगु।", "नमस्ते, शुभकामना, स्वागत र आधारभूत शिष्टाचारका शब्दहरू सिक्नुहोस्।", "Master essential greetings, courtesies, and polite introductions."),
            iconEmoji = "🙏",
            dialogues = listOf(
                DialogueLine(
                    speakerNewa = "सुमन",
                    speakerRole = LocalizedString("सुमन", "सुमन", "Suman"),
                    textNewa = "ज्वजलपा! छिगु नां छु खः?",
                    phonetic = "Jwajalapā! Chhigu nān chhu kha:?",
                    textNepali = "नमस्ते! तपाईंको नाम के हो?",
                    textEnglish = "Greetings! What is your name?"
                ),
                DialogueLine(
                    speakerNewa = "सलिना",
                    speakerRole = LocalizedString("सलिना", "सलिना", "Salina"),
                    textNewa = "ज्वजलपा! जिगु नां सलिना खः। छि गनं झायादीगु?",
                    phonetic = "Jwajalapā! Jigu nān Salinā kha:. Chhi ganan jhāyādīgu?",
                    textNepali = "नमस्ते! मेरो नाम सलिना हो। तपाईं कहाँबाट आउनुभएको?",
                    textEnglish = "Greetings! My name is Salina. Where did you come from?"
                ),
                DialogueLine(
                    speakerNewa = "सुमन",
                    speakerRole = LocalizedString("सुमन", "सुमन", "Suman"),
                    textNewa = "जि येँयाम्ह खः। छिंत नापलानाः तसकं लय्‍ताल।",
                    phonetic = "Ji Yenyāmha kha:. Chhita nāpalānā: tasakan laytāla.",
                    textNepali = "म काठमाडौँको हुँ। तपाईंलाई भेटेर धेरै खुसी लाग्यो।",
                    textEnglish = "I am from Kathmandu. It is a pleasure to meet you."
                ),
                DialogueLine(
                    speakerNewa = "सलिना",
                    speakerRole = LocalizedString("सलिना", "सलिना", "Salina"),
                    textNewa = "जिंत नं लय्‍ताल। छिंत तसकं सुभाय्!",
                    phonetic = "Jita nan laytāla. Chhita tasakan subhāy!",
                    textNepali = "मलाई पनि खुसी लाग्यो। तपाईंलाई धेरै धन्यवाद!",
                    textEnglish = "I am glad too. Thank you very much!"
                )
            ),
            vocabularies = listOf(
                vocabularies[0], // jwajalapa
                vocabularies[1], // bhintuna
                vocabularies[2], // subhay
                vocabularies[3], // laskus
                vocabularies[4]  // chhi / vayka
            ),
            grammarNotes = LocalizedString(
                newa = "'छि' (Chhi) आदरार्थी खँग्वः खः। थः स्वयां तःधिकःपिंत न्ह्याबलें 'छि' धायेमाः, 'छ' (Cha) धाये मज्यू।",
                nepali = "'छि' (Chhi) आदरार्थी शब्द हो। आफूभन्दा ठूलालाई सधैँ 'छि' भन्नुपर्छ, 'छ' (तँ) भन्नुहुँदैन।",
                english = "'Chhi' is the polite honorific pronoun for 'you'. Always address elders and acquaintances with 'Chhi', never 'Cha'."
            ),
            quizzes = listOf(
                QuizQuestion(
                    id = "q_1_1",
                    question = LocalizedString("नेपाल भाषाय् 'नमस्ते' यात छु धाइ?", "नेपाल भाषामा 'नमस्ते' लाई के भनिन्छ?", "How do you say 'Hello/Greetings' in Nepal Bhasa?"),
                    options = listOf("ज्वजलपा (Jwajalapa)", "सुभाय् (Subhay)", "भिंतुना (Bhintuna)", "लसकुस (Laskus)"),
                    correctIndex = 0,
                    explanation = LocalizedString("'ज्वजलपा' धाःगु नमस्कार खः।", "'ज्वजलपा' भनेको नमस्कार हो।", "'Jwajalapa' is the traditional respectful greeting.")
                ),
                QuizQuestion(
                    id = "q_1_2",
                    question = LocalizedString("'सुभाय्' खँग्वःया अर्थ छु खः?", "'सुभाय्' शब्दको अर्थ के हो?", "What does 'Subhay' mean?"),
                    options = listOf("स्वागत (Welcome)", "धन्यवाद (Thank you)", "शुभकामना (Best wishes)", "माफ गर्नुहोस् (Sorry)"),
                    correctIndex = 1,
                    explanation = LocalizedString("'सुभाय्' या अर्थ धन्यवाद खः।", "'सुभाय्' को अर्थ धन्यवाद हो।", "'Subhay' translates to 'Thank you'.")
                ),
                QuizQuestion(
                    id = "q_1_3",
                    question = LocalizedString("'छिगु नां छु खः?' या अर्थ छु खः?", "'छिगु नां छु खः?' को अर्थ के हो?", "What does 'Chhigu nān chhu kha:?' mean?"),
                    options = listOf("तपाईं कहाँ जानुहुन्छ?", "तपाईंको नाम के हो?", "तपाईंलाई कस्तो छ?", "तपाईं के खानुहुन्छ?"),
                    correctIndex = 1,
                    explanation = LocalizedString("नां = नाम, छु = के, खः = हो।", "नां = नाम, छु = के, खः = हो।", "Nān = Name, Chhu = What, Kha: = is.")
                )
            )
        ),
        LessonUnit(
            id = "unit_2",
            unitNumber = 2,
            title = LocalizedString("ल्याःचाः: अंक १ निसें १० व नेपाल संवत्", "अंक र गन्ती: १ देखि १० र नेपाल संवत्", "Numbers 1-10 & Nepal Sambat Counting"),
            description = LocalizedString("नेपाल भाषाया मौलिक अंक, गणना विधि व संवत् तिथिया ज्ञान।", "नेपाल भाषाको मौलिक संख्या प्रणाली र तिथि गन्ती सिक्नुहोस्।", "Learn Nepal Bhasa counting numerals and calendar calculations."),
            iconEmoji = "🔢",
            dialogues = listOf(
                DialogueLine(
                    speakerNewa = "दुकानदार",
                    speakerRole = LocalizedString("दुकानदार", "दुकानदार", "Shopkeeper"),
                    textNewa = "ज्वजलपा! छिंत गुलि चटामरि माः?",
                    phonetic = "Jwajalapā! Chhita guli chatāmari mā:?",
                    textNepali = "नमस्ते! तपाईंलाई कतिवटा चटामरी चाहियो?",
                    textEnglish = "Greetings! How many chatamaris would you like?"
                ),
                DialogueLine(
                    speakerNewa = "ग्राहक",
                    speakerRole = LocalizedString("ग्राहक", "ग्राहक", "Customer"),
                    textNewa = "जिंत निगु चटामरि व छगः वो बियादिसँ।",
                    phonetic = "Jita nigu chatāmari wa chhaga: woh biyādisan.",
                    textNepali = "मलाई दुईवटा चटामरी र एउटा बारा दिनुहोस्।",
                    textEnglish = "Please give me two chatamaris and one lentil patty (woh)."
                ),
                DialogueLine(
                    speakerNewa = "दुकानदार",
                    speakerRole = LocalizedString("दुकानदार", "दुकानदार", "Shopkeeper"),
                    textNewa = "ज्यू, मुक्कं स्वीन्यातका (२५) जुल।",
                    phonetic = "Jyu, mukkan swīnyātakā (25) jula.",
                    textNepali = "हस, जम्मा पच्चीस रुपैयाँ भयो।",
                    textEnglish = "Certainly, the total is twenty-five rupees."
                )
            ),
            vocabularies = listOf(
                vocabularies[10], // chhi (1)
                vocabularies[11], // nasi (2)
                vocabularies[12], // swa (3)
                vocabularies[13], // pi (4)
                vocabularies[14], // nya (5)
                vocabularies[15]  // jhi (10)
            ),
            grammarNotes = LocalizedString(
                newa = "वस्तु गणना यायेबलय् 'गु' (gu) प्रत्यय तइ: छगु (१), निगु (२), स्वंगु (३), प्यंगु (४), न्यागु (५)।",
                nepali = "वस्तु गणना गर्दा 'गु' (gu) प्रत्यय जोडिन्छ: छगु (१ वटा), निगु (२ वटा), स्वंगु (३ वटा), प्यंगु (४ वटा)।",
                english = "When counting physical objects, the classifier '-gu' is attached: Chhagu (1), Nigu (2), Swangu (3), Pyangu (4), Nyagu (5)."
            ),
            quizzes = listOf(
                QuizQuestion(
                    id = "q_2_1",
                    question = LocalizedString("नेपाल भाषाय् '२' (दुई) यात छु धाइ?", "नेपाल भाषामा '२' लाई के भनिन्छ?", "What is the number '2' in Nepal Bhasa?"),
                    options = listOf("निगु / नसि (Nasi)", "छगु (Chhi)", "स्वंगु (Swa)", "प्यंगु (Pi)"),
                    correctIndex = 0,
                    explanation = LocalizedString("२ = नसि / निगु खः।", "२ = नसि / निगु हो।", "'Nasi' or 'Nigu' means Two (2).")
                ),
                QuizQuestion(
                    id = "q_2_2",
                    question = LocalizedString("'स्वंगु' धाःगु गुलि ल्याः खः?", "'स्वंगु' भनेको कति संख्या हो?", "What count does 'Swangu' represent?"),
                    options = listOf("१", "३", "५", "१०"),
                    correctIndex = 1,
                    explanation = LocalizedString("स्वंगु = ३ (Three) खः।", "स्वंगु = ३ हो।", "'Swangu' signifies 3.")
                )
            )
        ),
        LessonUnit(
            id = "unit_3",
            unitNumber = 3,
            title = LocalizedString("छेँजः व स्वापू: मां-बा, किजा व पासा", "परिवार र नातागोता: आमा-बुबा र भाइ", "Family & Kinship: Parents & Siblings"),
            description = LocalizedString("परिवारया दुजःपिंत सःतेगु व आदरार्थी सम्बन्ध खँग्वःत।", "परिवारका सदस्यहरूलाई बोलाउने र आदरार्थी सम्बन्धका शब्दहरू।", "Terms for family members, siblings, elders, and respectful address."),
            iconEmoji = "👨‍👩‍👧‍👦",
            dialogues = listOf(
                DialogueLine(
                    speakerNewa = "अनिश",
                    speakerRole = LocalizedString("अनिश", "अनिश", "Anish"),
                    textNewa = "छिमि छेँय् सु सु दु?",
                    phonetic = "Chhimi chheny su su du?",
                    textNepali = "तपाईंको घरमा को-को हुनुहुन्छ?",
                    textEnglish = "Who is in your family?"
                ),
                DialogueLine(
                    speakerNewa = "रोशना",
                    speakerRole = LocalizedString("रोशना", "रोशना", "Roshana"),
                    textNewa = "जिमि छेँय् मां, बा, छम्ह किजा व जि दु।",
                    phonetic = "Jimi chheny mān, bā, chhamha kijā wa ji du.",
                    textNepali = "मेरो घरमा आमा, बुबा, एकजना भाइ र म छौँ।",
                    textEnglish = "In my home, there are my mother, father, one younger brother, and myself."
                ),
                DialogueLine(
                    speakerNewa = "अनिश",
                    speakerRole = LocalizedString("अनिश", "अनिश", "Anish"),
                    textNewa = "छिमि किजा ब्वनेकुथिइ वनी ला?",
                    phonetic = "Chhimi kijā bwanekuthiyi wanī lā?",
                    textNepali = "तपाईंको भाइ विद्यालय जान्छ?",
                    textEnglish = "Does your younger brother go to school?"
                ),
                DialogueLine(
                    speakerNewa = "रोशना",
                    speakerRole = LocalizedString("रोशना", "रोशना", "Roshana"),
                    textNewa = "खः, वय्कः कक्षा ८ य् ब्वनी।",
                    phonetic = "Kha:, vayka kakshā 8 y bwanī.",
                    textNepali = "हो, उनी कक्षा ८ मा पढ्छन्।",
                    textEnglish = "Yes, he studies in grade 8."
                )
            ),
            vocabularies = listOf(
                vocabularies[5], // ba
                vocabularies[6], // ma
                vocabularies[7], // kija
                vocabularies[8], // tata
                vocabularies[9]  // pasa
            ),
            grammarNotes = LocalizedString(
                newa = "मनूया ल्याः ल्हायेबलय् 'म्ह' (mha) प्रत्यय जुइ: छम्ह (एक जना), निम्ह (दुई जना), स्वम्ह (तीन जना)।",
                nepali = "मानिस गन्दा 'म्ह' (mha) प्रत्यय लाग्छ: छम्ह (१ जना), निम्ह (२ जना), स्वम्ह (३ जना)।",
                english = "For human beings, the numeral classifier '-mha' is used instead of '-gu': Chhamha (1 person), Nimha (2 people), Swamha (3 people)."
            ),
            quizzes = listOf(
                QuizQuestion(
                    id = "q_3_1",
                    question = LocalizedString("नेपाल भाषाय् 'भाइ' यात छु धाइ?", "नेपाल भाषामा 'भाइ' लाई के भनिन्छ?", "How do you say 'Younger Brother' in Nepal Bhasa?"),
                    options = listOf("किजा (Kija)", "दाजु (Daju)", "पासा (Pasa)", "बा (Ba)"),
                    correctIndex = 0,
                    explanation = LocalizedString("किजा = भाइ खः।", "किजा = भाइ हो।", "'Kija' means younger brother.")
                ),
                QuizQuestion(
                    id = "q_3_2",
                    question = LocalizedString("'पासा' खँग्वःया अर्थ छु खः?", "'पासा' शब्दको अर्थ के हो?", "What does 'Pasa' mean?"),
                    options = listOf("साथी (Friend)", "बहिनी (Sister)", "शिक्षक (Teacher)", "शत्रु (Enemy)"),
                    correctIndex = 0,
                    explanation = LocalizedString("'पासा' या अर्थ साथी / मित्र खः।", "'पासा' को अर्थ साथी हो।", "'Pasa' translates to friend.")
                )
            )
        ),
        LessonUnit(
            id = "unit_4",
            unitNumber = 4,
            title = LocalizedString("नसात्वँसा: परम्परागत नेवाः भोय्", "भोजन र परिकार: परम्परागत नेवारी भोज", "Newari Cuisine & Traditional Feasts"),
            description = LocalizedString("समोयबजि, चटामरि, योमरि, वो व भोय्या परिकारया नां।", "समयबजी, चटामरी, योमरी र नेवारी भोजका प्रसिद्ध परिकारहरू।", "Learn names, etiquette, and preparation of Newari culinary treasures."),
            iconEmoji = "🍲",
            dialogues = listOf(
                DialogueLine(
                    speakerNewa = "आतिथ्यकर्ता",
                    speakerRole = LocalizedString("आतिथ्यकर्ता", "आतिथ्यकर्ता", "Host"),
                    textNewa = "लसकुस! सुकुलय् फ्यतुनादिसँ, भोय् न्ह्याके।",
                    phonetic = "Laskus! Sukulay phyatunādisan, bhoy nhyāke.",
                    textNepali = "स्वागत छ! सुकुलमा बस्नुहोस्, भोज सुरु गरौँ।",
                    textEnglish = "Welcome! Please take a seat on the straw mat (sukul), let's begin the feast."
                ),
                DialogueLine(
                    speakerNewa = "पाहुना",
                    speakerRole = LocalizedString("पाहुना", "पाहुना", "Guest"),
                    textNewa = "समोयबजि तसकं बांलाक ल्हानादीगु दु। छु छु परिकार दु?",
                    phonetic = "Samaybaji tasakan bānlāka lhānādīgu du. Chhu chhu parikār du?",
                    textNepali = "समयबजी धेरै राम्रोसँग पस्कनुभएछ। के के परिकार छ?",
                    textEnglish = "The Samaybaji platter is presented beautifully. What dishes are here?"
                ),
                DialogueLine(
                    speakerNewa = "आतिथ्यकर्ता",
                    speakerRole = LocalizedString("आतिथ्यकर्ता", "आतिथ्यकर्ता", "Host"),
                    textNewa = "बजि (चिउरा), हाकुमुस्या (कालो भटमास), छोयला, पालु (अदुवा) व खेँय् दु।",
                    phonetic = "Baji, Hākumusyā, Chhoylā, Pālu wa Kheny du.",
                    textNepali = "चिउरा, कालो भटमास, छोयला, अदुवा र अन्डा छन्।",
                    textEnglish = "Beaten rice, roasted black soybeans, spiced meat (chhoyla), ginger, and egg."
                )
            ),
            vocabularies = listOf(
                vocabularies[1], // samaybaji
                vocabularies[2], // yomari
                vocabularies[3], // chatamari
                vocabularies[4]  // woh
            ),
            grammarNotes = LocalizedString(
                newa = "'नयेगु' (Nayegu) धाःगु नयेगु खः, आदरार्थी रुप 'नयादीगु' (Nayādīgu) जुइ।",
                nepali = "'नयेगु' भनेको खानु हो, यसको आदरार्थी रूप 'नयादीगु' हुन्छ।",
                english = "'Nayegu' means to eat. In polite speech for guests and elders, use 'Nayadigu'."
            ),
            quizzes = listOf(
                QuizQuestion(
                    id = "q_4_1",
                    question = LocalizedString("'चटामरि' या मुख्य पीठो छु खः?", "'चटामरी' को मुख्य पीठो के हो?", "What is the primary flour used for Chatamari?"),
                    options = listOf("जाकि (चामलको पीठो / Rice flour)", "छ्व (गहुँको पीठो / Wheat)", "कँय् (मकैको पीठो / Corn)", "मुस्या (भटमास)"),
                    correctIndex = 0,
                    explanation = LocalizedString("चटामरि जाकिया पिठों दयेकी।", "चटामरी चामलको पीठोबाट बनाइन्छ।", "Chatamari is made from fine rice flour batter.")
                )
            )
        ),
        LessonUnit(
            id = "unit_5",
            unitNumber = 5,
            title = LocalizedString("न्हियान्हिथंया खँल्हाबल्हा व क्रिया", "दैनिक बोलीचाली र मुख्य क्रियापद", "Daily Conversation & Core Verbs"),
            description = LocalizedString("वनेगु, वयेगु, ल्हायेगु, यायेगु क्रियाया काल व वाक्य निर्माण।", "जानु, आउनु, बोल्नु, गर्नु जस्ता क्रियापद र वाक्य बनाउने नियम।", "Conjugating essential verbs (to go, come, speak, do) in everyday phrases."),
            iconEmoji = "🗣️",
            dialogues = listOf(
                DialogueLine(
                    speakerNewa = "रवि",
                    speakerRole = LocalizedString("रवि", "रवि", "Ravi"),
                    textNewa = "छि गन वनेत्यनादीगु?",
                    phonetic = "Chhi gan wanetyanādīgu?",
                    textNepali = "तपाईं कहाँ जान लाग्नुभएको?",
                    textEnglish = "Where are you heading to?"
                ),
                DialogueLine(
                    speakerNewa = "दीपा",
                    speakerRole = LocalizedString("दीपा", "दीपा", "Deepa"),
                    textNewa = "जि असनय् बजाः वनेत्यना। छि नं वयेगु ला?",
                    phonetic = "Ji Asanay bajā: wanetyanā. Chhi nan wayegu lā?",
                    textNepali = "म असनमा बजार जान लागेकी। तपाईं पनि आउने?",
                    textEnglish = "I am heading to Asan market. Would you like to come along?"
                ),
                DialogueLine(
                    speakerNewa = "रवि",
                    speakerRole = LocalizedString("रवि", "रवि", "Ravi"),
                    textNewa = "खः, जि नं वये। न्हिला वनेनु!",
                    phonetic = "Kha:, ji nan waye. Nhilā wanenu!",
                    textNepali = "हुन्छ, म पनि आउँछु। सँगै जाऔँ!",
                    textEnglish = "Yes, I will come too. Let's go together!"
                )
            ),
            vocabularies = listOf(
                vocabularies[16], // wanegu
                vocabularies[17], // wayegu
                vocabularies[18], // nayegu
                vocabularies[19]  // lhayegu
            ),
            grammarNotes = LocalizedString(
                newa = "'वनेगु' (जानु): जि वना (म गएँ), जि वने (म जानेछु), छि झायादिसँ (तपाईं जानुहोस्)।",
                nepali = "'वनेगु' (जानु): जि वना (म गएँ), जि वने (म जानेछु), छि झायादिसँ (तपाईं जानुहोस्)।",
                english = "Verb conjugation for 'Wanegu' (To go): Ji wana (I went), Ji wane (I will go), Chhi jhayadisan (Please go - honorific)."
            ),
            quizzes = listOf(
                QuizQuestion(
                    id = "q_5_1",
                    question = LocalizedString("'नेपाल भाषा ल्हायेगु' धाःगु छु खः?", "'नेपाल भाषा ल्हायेगु' को अर्थ के हो?", "What does 'Nepal Bhasa Lhayegu' mean?"),
                    options = listOf("नेपाल भाषा बोल्नु (To speak Nepal Bhasa)", "नेपाल भाषा लेख्नु (To write)", "नेपाल भाषा सुन्नु (To listen)", "नेपाल भाषा बिर्सनु (To forget)"),
                    correctIndex = 0,
                    explanation = LocalizedString("ल्हायेगु = बोल्नु / कुरा गर्नु।", "ल्हायेगु = बोल्नु हो।", "'Lhayegu' means to speak or converse.")
                )
            )
        ),
        LessonUnit(
            id = "unit_6",
            unitNumber = 6,
            title = LocalizedString("खँत्वाः व लोकज्ञान: नेवाः उखान", "उखान र लोकज्ञान: नेवार जीवनदर्शन", "Proverbs & Cultural Wisdom"),
            description = LocalizedString("सयौं दँनिसें न्ह्याना वयाच्वंगु जीवनोपयोगी नेवाः खँत्वाः (उखान)।", "पुस्तौँदेखि चलिआएका जीवनोपयोगी नेवारी उखान र टुक्काहरू।", "Centuries-old idiomatic proverbs reflecting Kathmandu Valley philosophy."),
            iconEmoji = "💡",
            dialogues = listOf(
                DialogueLine(
                    speakerNewa = "अजी (हजुरआमा)",
                    speakerRole = LocalizedString("हजुरआमा", "हजुरआमा", "Grandmother"),
                    textNewa = "याच्वं, न्ह्याबलें मतिना व सत्य ल्हायेमाः।",
                    phonetic = "Yāchwan, nhyābalen matinā wa satya lhāyemā:.",
                    textNepali = "नाति, सधैँ माया र सत्य बोल्नुपर्छ।",
                    textEnglish = "Grandson, always speak with love and truth."
                ),
                DialogueLine(
                    speakerNewa = "नाति",
                    speakerRole = LocalizedString("नाति", "नाति", "Grandson"),
                    textNewa = "अजी, झीगु नेवाः खँत्वाः 'मनू सियाः नां ल्यनी' या अर्थ छु खः?",
                    phonetic = "Ajī, jhīgu Newā: khãtwā: 'Manū siyā: nān lyani' yā artha chhu kha:?",
                    textNepali = "हजुरआमा, हाम्रो नेवारी उखान 'मान्छे मरेर नाम रहन्छ' को अर्थ के हो?",
                    textEnglish = "Grandmother, what does the proverb 'A human passes leaving a name' mean?"
                ),
                DialogueLine(
                    speakerNewa = "अजी (हजुरआमा)",
                    speakerRole = LocalizedString("हजुरआमा", "हजुरआमा", "Grandmother"),
                    textNewa = "मनू मदुसां वं याःगु बांलाःगु ज्या हलिमय् अमर जुयाच्वनी।",
                    phonetic = "Manū madusān van yā:gu bānlā:gu jyā halimay amar juyāchwanī.",
                    textNepali = "मानिस नरहे पनि उसले गरेको राम्रो कर्म सधैँ अमर रहन्छ।",
                    textEnglish = "Even after a person passes, the goodness of their noble deeds remains immortal."
                )
            ),
            vocabularies = listOf(
                vocabularies[23], // khantwa1
                vocabularies[24]  // khantwa2
            ),
            grammarNotes = LocalizedString(
                newa = "'खँत्वाः' (Khãtwā:) धाःगु उखान खः, गुकिं जीवनया गहिरो सत्य क्यनी।",
                nepali = "'खँत्वाः' भन्नाले उखान हो, जसले जीवनको गहिरो दर्शन सिकाउँछ।",
                english = "'Khãtwā:' are traditional epigrams and proverbs that distill moral wisdom into rhyming phrases."
            ),
            quizzes = listOf(
                QuizQuestion(
                    id = "q_6_1",
                    question = LocalizedString("'नसा म्वाःसा भ्वाः, खँ म्वाःसा ...' खाली थाय् पूवंकेदिसँ।", "'नसा म्वाःसा भ्वाः, खँ म्वाःसा ...' खाली ठाउँ भर्नुहोस्।", "Complete the proverb: 'Nasā mwāsā bhwā:, khã mwāsā ...'"),
                    options = listOf("ल्वाः (झगडा / Dispute)", "सुभाय् (धन्यवाद)", "भोय् (भोज)", "पासा (साथी)"),
                    correctIndex = 0,
                    explanation = LocalizedString("'खँ म्वाःसा ल्वाः' = धेरै बोले झगडा हुन्छ।", "'खँ म्वाःसा ल्वाः' = धेरै बोले झगडा हुन्छ।", "'Khã mwāsā lwā:' warns that excessive talking causes strife.")
                )
            )
        )
    )

    // --- CULTURAL FESTIVALS (NEPAL SAMBAT CALENDAR) ---
    val culturalFestivals: List<CulturalFestival> = listOf(
        CulturalFestival(
            id = "f_mhapuja",
            name = LocalizedString("म्हा पूजा व न्हुदँ", "म्हा पूजा र नयाँ वर्ष", "Mha Puja & Nepal Sambat New Year"),
            sambatDate = "कछलाथ्व पारु ११४६",
            gregorianMonth = "October / November",
            description = LocalizedString(
                newa = "थःगु म्ह (आत्मा) यात द्यःया रुपं पूजा यानाः नयाँ संवत् हनेगु पावन दिं।",
                nepali = "आफ्नो शरीर र आत्मालाई देवताको रूपमा पूजा गरी नयाँ वर्ष मनाउने पवित्र दिन।",
                english = "Auspicious celebration sanctifying one's own soul and body with geometric mandalas on the New Year."
            ),
            traditions = LocalizedString(
                newa = "तैल मन्दः (मण्डल) दयेकाः शगुन, फलफूल व खेलुइताः (विशेष बत्ती) बाले याइ।",
                nepali = "तेलको मण्डल बनाएर सगुन, फलफूल र विशेष बत्ती बालिन्छ।",
                english = "Drawing intricate oil mandalas, offering sagun prasad, and lighting long cotton wick lamps (khelu-ita)."
            ),
            specialFood = LocalizedString("मन्दः सगुन, समयबजी, अय्लाः", "सगुन, समयबजी, फलफूल", "Sagun, Samaybaji, Aila, Walnuts"),
            iconEmoji = "🪔"
        ),
        CulturalFestival(
            id = "f_yomaripunhi",
            name = LocalizedString("योमरी पुन्हि", "योमरी पूर्णिमा", "Yomari Punhi (Harvest Moon)"),
            sambatDate = "थिंलाथ्व पुन्हि ११४६",
            gregorianMonth = "December",
            description = LocalizedString(
                newa = "न्हूगु धान्या लसताय् चाकु व तिल तयाः दयेकूगु योमरि अन्नपूर्णा देवीयात छायेगु पर्व।",
                nepali = "नयाँ धान भित्र्याएको खुसीमा चाकु र तिलको योमरी बनाई अन्नपूर्णा देवीलाई चढाउने पर्व।",
                english = "Harvest celebration offering freshly steamed sweet rice dumplings to Goddess Annapurna."
            ),
            traditions = LocalizedString(
                newa = "मस्त 'त्यःछिं त्यः' म्येँ हालसें त्वाःत्वालय् योमरि फ्वनेगु रमाइलो याइ।",
                nepali = "बालबालिका 'त्यःछिं त्यः' गीत गाउँदै टोलटोलमा योमरी माग्ने गर्दछन्।",
                english = "Children sing the traditional festive carol 'Tyochhin Tyo' visiting neighborhood homes."
            ),
            specialFood = LocalizedString("योमरि (चाकु व खुवा)", "योमरी (चाकु र खुवा)", "Yomari with molten jaggery and khuwa"),
            iconEmoji = "🥟"
        ),
        CulturalFestival(
            id = "f_yenya",
            name = LocalizedString("येँयाः (इन्द्र जात्रा)", "येँयाः (इन्द्रजात्रा)", "Yenya: (Indra Jatra)"),
            sambatDate = "ञंलाथ्व द्वादशी निसें ११४६",
            gregorianMonth = "September",
            description = LocalizedString(
                newa = "श्री कुमारी, गणेश व भैरवया रथयात्रा नापं येँया ऐतिहासिक दकलय् तःधंगु जात्रा।",
                nepali = "जीवित देवी श्री कुमारी, गणेश र भैरवको रथयात्रा सहित काठमाडौँको सबैभन्दा ठूलो ऐतिहासिक जात्रा।",
                english = "Grandest street carnival of Kathmandu featuring the chariot processions of Living Goddess Kumari, Ganesh, and Bhairav."
            ),
            traditions = LocalizedString(
                newa = "मजिपाः लाखे, पुलुकिसि (हात्ती) नाच व श्वेत भैरवया म्हुतुं अय्लाः त्वंकीगु।",
                nepali = "मजीपा लाखे, पुलुकिसि (ऐरावत हात्ती) नाच र श्वेत भैरवबाट प्रसाद वितरण।",
                english = "Masked dances of Majipa Lakhey, Pulukisi, and distribution of sanctified nectar from the Sweta Bhairav mask."
            ),
            specialFood = LocalizedString("समोयबजि, हाथु हायेकीगु अय्लाः", "समयबजी, हाथु प्रसाद", "Samaybaji feast and consecrated Aila"),
            iconEmoji = "👺"
        ),
        CulturalFestival(
            id = "f_bisket",
            name = LocalizedString("बिस्काः जात्रा (ख्वप)", "बिस्काः जात्रा (भक्तपुर)", "Biska: Jatra (Bhaktapur Chariot Festival)"),
            sambatDate = "चौलागाः ११४६",
            gregorianMonth = "April",
            description = LocalizedString(
                newa = "भैरवनाथ व भद्रकालीया भव्य रथ सालेगु व योसिंद्यो (लिङ्गो) थनेगु ऐतिहासिक जात्रा।",
                nepali = "भैरवनाथ र भद्रकालीको भव्य रथ तान्ने तथा ५५ हात अग्लो लिङ्गो ठड्याउने जात्रा।",
                english = "Thrilling tug-of-war chariot festival of Bhairavnath and raising of the 55-cubit ceremonial tree pole (Yosin)."
            ),
            traditions = LocalizedString(
                newa = "क्वहने व थनेया मनूतय्सं रथ सालेगु धेंधेंबल्लाः याइ।",
                nepali = "तल्लो र माथिल्लो टोलका बासिन्दाबीच रथ तान्ने रोचक प्रतिस्पर्धा हुन्छ।",
                english = "Passionate competition between upper and lower city quarters to haul the massive multi-tiered pagoda chariot."
            ),
            specialFood = LocalizedString("जुजुधौ (दही), छोयला, वो", "जुजुधौ (राजा दही), छोयला", "Famous Bhaktapur Juju Dhau (King Curd) and spicy roasted meats"),
            iconEmoji = "🎪"
        )
    )

    // --- SCRIPT GLYPHS (DEVANGARI & NEPAL LIPi / RANJANA LIPi GUIDE) ---
    val scriptGlyphs: List<ScriptGlyph> = listOf(
        ScriptGlyph("अ", "A", "a", "आखः (Letter / Script)", "Letter or Alphabet", true),
        ScriptGlyph("आ", "Aa", "ā", "आबः (Vermilion)", "Red vermilion powder", true),
        ScriptGlyph("इ", "I", "i", "इलय् (At time)", "During or in time", true),
        ScriptGlyph("ई", "Ee", "ī", "ई (Time)", "Time or Era", true),
        ScriptGlyph("उ", "U", "u", "उसाँय् (Health)", "Wellbeing & Health", true),
        ScriptGlyph("ए", "E", "e", "ऐला (Aila)", "Sacred rice spirit", true),
        ScriptGlyph("क", "Ka", "ka", "किजा (Brother)", "Younger Brother", false),
        ScriptGlyph("ख", "Kha", "kha", "खँग्वः (Word)", "Word or Term", false),
        ScriptGlyph("ग", "Ga", "ga", "गुथि (Guthi)", "Community trust", false),
        ScriptGlyph("घ", "Gha", "gha", "घः (Clay pot)", "Earthen jar", false),
        ScriptGlyph("च", "Cha", "cha", "चटामरि (Chatamari)", "Rice-flour crepe", false),
        ScriptGlyph("छ", "Chha", "chha", "छि (You / 1)", "Polite 'You' or count 'One'", false),
        ScriptGlyph("ज", "Ja", "ja", "ज्वजलपा (Jwajalapa)", "Greetings", false),
        ScriptGlyph("झ", "Jha", "jha", "झी (We / 10)", "Inclusive 'We' or count 'Ten'", false),
        ScriptGlyph("त", "Ta", "ta", "ताता (Elder Sister)", "Elder sister", false),
        ScriptGlyph("थ", "Tha", "tha", "थ्यासफू (Thyasaphu)", "Accordion manuscript book", false),
        ScriptGlyph("द", "Da", "da", "दबू (Dabali)", "Open cultural stage platform", false),
        ScriptGlyph("न", "Na", "na", "नसात्वँसा (Food)", "Food and drink delicacies", false),
        ScriptGlyph("प", "Pa", "pa", "पासा (Friend)", "Companion or friend", false),
        ScriptGlyph("भ", "Bha", "bha", "भिंतुना (Bhintuna)", "Warm blessings / congratulations", false),
        ScriptGlyph("म", "Ma", "ma", "मां (Mother)", "Beloved mother", false),
        ScriptGlyph("य", "Ya", "ya", "योमरि (Yomari)", "Sweet confection", false),
        ScriptGlyph("ल", "La", "la", "ल्हाय्गु (To speak)", "Speech and expression", false),
        ScriptGlyph("स", "Sa", "sa", "समोयबजि (Samaybaji)", "Auspicious festive feast", false)
    )

    // --- NEPAL SAMBAT CURRENT METADATA ---
    val currentNepalSambatYear = "११४६"
    val currentNepalSambatMonth = LocalizedString("कछला", "कछला", "Kachhala")
    val currentPaksha = LocalizedString("थ्व (शुक्ल)", "शुक्ल पक्ष", "Shukla Paksha (Waxing)")
    val currentTithi = LocalizedString("पारु (प्रतिपदा)", "प्रतिपदा", "Pratipada (First Lunar Day)")

    // --- CULTURAL HISTORY & TRADITIONS DATA ---
    val culturalHistoryTopics: List<CulturalHistoryTopic> = listOf(
        CulturalHistoryTopic(
            id = "hist_sakhwa",
            title = LocalizedString("शंखधर साख्वा व नेपाल संवत्", "शंखधर साख्वा र नेपाल संवत्को इतिहास", "Shankhadhar Sakhwa & Nepal Sambat History"),
            subtitle = LocalizedString("गरिब जनताया त्यासा मोचन यानाः न्ह्याकूगु मौलिक संवत्", "गरिब जनताको ऋण मोचन गरी सुरु गरिएको मौलिक राष्ट्रिय संवत्", "The Indigenous Era founded by liberating all citizens from debt"),
            content = LocalizedString(
                newa = """
                    नेपाल संवत् ८७९ ईस्वी (ने.सं. १) य् राष्ट्रिय विभूति शंखधर साख्वां सुरु यानादीगु खः। वं येँया लखुतीर्थ (विष्णुमती खुसि) या बालुवा लुँ (सुन) य् हिला वनेधुंकाः थःगु दक्वं सम्पत्तिं काठमाडौँ उपत्यकाया गरिब जनताया त्यासा (ऋण) पूनाः मुक्त यानादिल। थ्व लसताय् थ्व संवत् न्ह्याकल।
                    
                    मल्लकालय् थ्व संवत् नेपालया औपचारिक सरकारी संवत् जूगु खः। शिलालेख, ताडपत्र, सिक्का व सरकारी दस्तावेज दक्व थ्व हे संवत् प्रयोग जुयाच्वंगु खः।
                """.trimIndent(),
                nepali = """
                    नेपाल संवत् ईस्वी संवत् ८७९ मा राष्ट्रिय विभूति शंखधर साख्वाले सुरु गर्नुभएको हो। उहाँले काठमाडौँको लखुतीर्थ (विष्णुमती नदी) को बालुवा सुनमा परिणत भएपछि आफ्नो सम्पूर्ण सम्पत्तिबाट काठमाडौँ उपत्यकाका गरिब जनताको सम्पूर्ण ऋण तिरी ऋणमुक्त गरिदिनुभयो। यही ऐतिहासिक उपलक्ष्यमा नेपाल संवत् सुरु भएको हो।
                    
                    मल्लकालभर यो संवत् नेपालको आधिकारिक राजकीय संवत् रह्यो। शिलालेख, ताडपत्र, मुद्रा र ऐतिहासिक दस्तावेज सबैमा यही संवत् अंकित छ।
                """.trimIndent(),
                english = """
                    Nepal Sambat was established in 879 CE by the national hero Shankhadhar Sakhwa. Legend and chronicles record that sands collected from Lakhu Tirtha (Bishnumati river) turned to gold; Sakhwa used this miraculous fortune to repay the entire debt of every impoverished citizen across the Kathmandu Valley, liberating them into freedom and dignity.
                    
                    For over 800 years, throughout the glorious Malla epoch, Nepal Sambat served as the sovereign official state calendar of Nepal, inscribed upon thousands of stone steles, copper plates, coins, and treaty documents.
                """.trimIndent()
            ),
            drawableResId = com.example.R.drawable.ic_shankhadhar_history,
            periodOrContext = LocalizedString("८७९ ईस्वी (मल्लकाल)", "८७९ ईस्वी (मल्लकाल)", "879 CE (Malla Golden Age)"),
            keyHighlights = listOf(
                LocalizedString("त्यासा मोचन (ऋण मुक्ति)", "ऋण मुक्ति दिवस", "Liberation from Citizen Debt"),
                LocalizedString("नेपालया आफ्नै मौलिक संवत्", "नेपालको मौलिक संवत्", "Nepal's Indigenous Sovereign Era"),
                LocalizedString("राष्ट्रिय विभूति शंखधर साख्वा", "राष्ट्रिय विभूति साख्वा", "National Hero Shankhadhar Sakhwa")
            )
        ),
        CulturalHistoryTopic(
            id = "hist_guthi",
            title = LocalizedString("गुथि प्रथा व सामाजिक सहकार्य", "गुठी प्रथा र सामाजिक एकता", "The Sacred Guthi System & Communal Governance"),
            subtitle = LocalizedString("हजारौं दँनिसें सम्पदा म्वाका तःगु नेवाः सामाजिक संस्था", "हजारौँ वर्षदेखि सम्पदा जीवित राख्ने नेवार सामाजिक संस्था", "Centuries-old socioeconomic backbone preserving temples and waters"),
            content = LocalizedString(
                newa = """
                    नेवाः समाजया दकलय् तःधंगु विशेषता 'गुथि' व्यवस्था खः। गुथि धाःगु केवल पूजा यायेगु जक मखु, थ्व नगरया भौतिक सम्पदा, ल्वहँहिति (ढुङ्गेधारा), पुखू, सतः, देगः, बाजा व मृत्यु संस्कार (सी गुथि) सञ्चालन यायेगु स्वायत्त संस्था खः।
                    
                    गुथि समाजया जग्गा व कोषपाखें वार्षिक चाडपर्व व मर्मत खर्च जुइ। थ्व व्यवस्थां यानाः भूकम्प व प्राकृतिक विपत्तिइ नं नेवाः परम्परा निरन्तर म्वानाच्वंगु दु।
                """.trimIndent(),
                nepali = """
                    नेवार समाजको सबैभन्दा बलियो जग 'गुठी' प्रणाली हो। गुठी केवल पूजाआजामा सीमित नभई सहरका ढुङ्गेधारा, इनार, पोखरी, पाटी-पौवा, मन्दिर, परम्परागत संगीत र मृत्यु संस्कार (सी गुठी) सञ्चालन गर्ने ऐतिहासिक स्वायत्त संस्था हो।
                    
                    गुठीका नाममा राखिएका जग्गा र अक्षयकोषबाट नै जात्रा र सम्पदा संरक्षणको खर्च जुट्दछ। यसै सामूहिक ऐक्यबद्धताका कारण भूकम्प र विपत्तिमा पनि उपत्यकाको जीवन्त संस्कृति अक्षुण्ण रह्यो।
                """.trimIndent(),
                english = """
                    The Guthi system is the socio-religious and architectural cornerstone of Newar civilization. Far beyond simple trusts, Guthis are autonomous institutions responsible for conserving water conduits (Hiti, Pukhu), pagoda temples, community pavilions (Sattal), musical gharanas (Dhimay, Bansuri), and funeral societies (Sī Guthi).
                    
                    Endowed with agricultural land, the revenues sustain annual festivals, temple restorations, and communal solidarity. This decentralised heritage model has kept Kathmandu Valley's living traditions vibrant through millennia.
                """.trimIndent()
            ),
            drawableResId = com.example.R.drawable.ic_pagoda_temple,
            periodOrContext = LocalizedString("प्राचीन लिच्छवि व मल्लकाल", "प्राचीन लिच्छवि तथा मल्लकाल", "Ancient Licchavi & Medieval Era"),
            keyHighlights = listOf(
                LocalizedString("सी गुथि (मृत्यु संस्कार)", "सी गुठी (सामाजिक सहकार्य)", "Sī Guthi (Compassionate Funeral Society)"),
                LocalizedString("जलसम्पदा व ढुङ्गेधारा संरक्षण", "ढुङ्गेधारा र पोखरी संरक्षण", "Water Spout & Hydraulic Stewardship"),
                LocalizedString("सामूहिक भोज व संगीत", "सामूहिक भोज र बाजागाजा", "Communal Feasts & Heritage Music")
            )
        ),
        CulturalHistoryTopic(
            id = "hist_rites",
            title = LocalizedString("म्हा पूजा व जीवनचक्र संस्कार", "म्हा पूजा र जीवनचक्रका मौलिक संस्कार", "Mha Puja & Sacred Life-Cycle Rites"),
            subtitle = LocalizedString("थःगु आत्माया पूजा व नेवाः मिसातयगु अद्वितीय परम्परा", "आफ्नै आत्माको पूजा र नेवार महिलाहरूको अद्वितीय परम्परा", "Worship of the Self, Ihi (Bel-Bibaha), and Janko Longevity"),
            content = LocalizedString(
                newa = """
                    नेवाः संस्कृतिय् जन्म निसें वृद्ध अवस्थातक थीथी विशिष्ट संस्कार जुइ। न्हुदँया दिं जुइगु 'म्हा पूजा' य् प्रत्येक मनूं थःगु दुनेया आत्मायात द्यःया रुपं पुजा याइ, गुकिं आत्मसम्मान व आध्यात्मिक शुद्धता बियाच्वनी।
                    
                    अथे हे मिसा मस्तेगु 'इहि' (बेल विवाह) व 'बाव्ह्रा तय्गु' (सूर्य दर्शन) संस्कारं मिसातय्त आजीवन सौभाग्यवती व स्वतन्त्र अधिकार बीगु विश्वास दु। उमेर ७७, ८३, ८८ व ९९ दँ द्यनेबलय् 'ज्या जंकु' यानाः रथय् तयाः नगर परिक्रमा याकेगु अद्वितीय आदर भाव नेवाः समाजया गौरव खः।
                """.trimIndent(),
                nepali = """
                    नेवार संस्कृतिमा जन्मदेखि वृद्ध अवस्थासम्म अनेकौँ अद्वितीय संस्कारहरू सम्पन्न हुन्छन्। नेपाल संवत् नयाँ वर्षको दिन गरिने 'म्हा पूजा' मा प्रत्येक व्यक्तिले आफ्नै आत्मा र शरीरलाई देवता ठानेर पूजा गर्दछन्, जसले आत्मगौरव र आत्मशुद्धि सिकाउँछ।
                    
                    त्यस्तै बालिकाहरूको 'इहि' (बेल विवाह) र 'गुफा राख्ने' (बाव्ह्रा तय्गु) संस्कारले महिलाहरूलाई समाजमा उच्च मर्यादा र सुरक्षा प्रदान गर्दछ। ७७, ८३, ८८ र ९९ वर्ष पुगेपछि 'ज्या जंकु' (भीमरथारोहण) गरी रथमा राखेर नगर परिक्रमा गराउने चलनले ज्येष्ठ नागरिकप्रतिको अगाध सम्मान दर्शाउँछ।
                """.trimIndent(),
                english = """
                    Newar culture observes sublime philosophical rites throughout life. 'Mha Puja' (Worship of the Self) on the New Year sanctifies each person's inner divinity with oil mandalas, promoting spiritual self-respect.
                    
                    Young girls undergo 'Ihi' (sacred marriage with the eternal bael fruit / Lord Vishnu), ensuring lifelong spiritual sanctity. Furthermore, elderly citizens who reach milestones of 77, 83, 88, and 99 years are honored with grand 'Janko' chariot processions around the city, reifying deep ancestral reverence.
                """.trimIndent()
            ),
            drawableResId = com.example.R.drawable.ic_mandala_mhapuja,
            periodOrContext = LocalizedString("सनातन नेवाः संस्कार", "सनातन नेवाः संस्कार", "Timeless Cultural Rites"),
            keyHighlights = listOf(
                LocalizedString("म्हा पूजा (आत्म पूजा)", "म्हा पूजा (आत्म पूजा)", "Mha Puja (Worship of Self)"),
                LocalizedString("इहि (बेल विवाह) व गुफा", "इहि र बाव्ह्रा (गुफा)", "Ihi & Bahra Rites"),
                LocalizedString("ज्या जंकु (भीमरथारोहण)", "ज्या जंकु (रथ परिक्रमा)", "Janko (Elder Chariot Honors)")
            )
        ),
        CulturalHistoryTopic(
            id = "hist_cuisine",
            title = LocalizedString("नेवाः नसात्वँसा: पोषण व विज्ञान", "नेवारी परिकार: पोषण र ऋतुविज्ञान", "Newari Cuisine: Gastronomy & Seasonal Science"),
            subtitle = LocalizedString("समोयबजि, योमरि, चटामरि व पञ्चतत्वया भोजन", "समयबजी, योमरी, चटामरी र पञ्चतत्वको सन्तुलन", "Culinary mastery connecting five cosmic elements with culinary taste"),
            content = LocalizedString(
                newa = """
                    नेवाः भोजन केवल स्वाद जक मखु, थ्व पञ्चतत्व (पृथ्वी, जल, तेज, वायु, आकाश) यात सन्तुलनय् तइगु विज्ञान खः। समोयबजिइ बजि (चिउरा), हाकुमुस्या (कालो भटमास), छोयला (मासु), पालु (अदुवा) व ऐला (मदिरा) या संयोजनं शरीरयात ऊर्जा व पाचन शक्ति बी।
                    
                    योमरि चिकुलाया इलय् म्हयात क्वाकः तयेत चाकु व तिल तयाः दयेकीसा चटामरि जाकिया पिठों दयेकीगु स्वादिष्ठ परिकार खः।
                """.trimIndent(),
                nepali = """
                    नेवारी भोजन स्वाद मात्र नभई पञ्चतत्वलाई सन्तुलनमा राख्ने अचम्मको वैज्ञानिक कला हो। समयबजीमा प्रयोग हुने चिउरा, कालो भटमास, छोयला, अदुवा र ऐलाको समिश्रणले पाचन क्रिया र रोग प्रतिरोधात्मक क्षमता बढाउँछ।
                    
                    जाडो याममा खाइने योमरीमा चाकु र तिलको प्रयोगले शरीरलाई भित्रैदेखि न्यानो राख्छ भने चटामरी चामलको पीठोबाट बन्ने स्वस्थकर मौलिक खाजा हो।
                """.trimIndent(),
                english = """
                    Newari culinary traditions harmonise the five primal elements (Earth, Water, Fire, Air, Space). The auspicious 'Samaybaji' platter combines flattened rice (Earth), black soybeans, ginger, spiced meat, and sacred fermented spirit (Aila) to invigorate bodily digestion and immunity.
                    
                    'Yomari' pastries stuffed with nutrient-dense jaggery molasses and sesame protect during harsh Himalayan winters, while crispy 'Chatamari' rice-batter crepes exemplify versatile agrarian culinary art.
                """.trimIndent()
            ),
            drawableResId = com.example.R.drawable.ic_yomari_tradition,
            periodOrContext = LocalizedString("मौलिक स्वाद व परम्परा", "मौलिक स्वाद र परम्परा", "Heritage Culinary Science"),
            keyHighlights = listOf(
                LocalizedString("समोयबजि (पञ्चतत्व सन्तुलन)", "समयबजी (शुभ भोजन)", "Samaybaji Auspicious Platter"),
                LocalizedString("योमरि (जाडोया चाकु परिकार)", "योमरी (चाकु र तिल)", "Yomari Winter Sweet Pastry"),
                LocalizedString("चटामरि व बारा (वो)", "चटामरी र बारा", "Chatamari & Woh Crepes")
            )
        )
    )

    // --- DEVELOPER CONTACT & FEEDBACK INFO ---
    const val DEVELOPER_EMAIL = "awiskaracharya@gmail.com"
    const val DEVELOPER_WHATSAPP = "+9779827106244"
    const val DEVELOPER_WHATSAPP_LINK = "https://wa.me/9779827106244"
    const val DEVELOPER_LINKEDIN = "https://www.linkedin.com/in/awiskaracharya/"
    const val DEVELOPER_NAME = "Awiskar Acharya"
}
