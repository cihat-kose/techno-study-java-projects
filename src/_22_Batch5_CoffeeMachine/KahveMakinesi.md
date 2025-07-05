## Basit bir kahve makinesi oluşturun.

   - Sistem şu soruyu sormalıdır: "Hangi kahveyi istersiniz?"
   - Türk Kahvesi
   - Filtre Kahve
   - Espresso

"hangiKahve" adında bir String oluşturun ve mevcut kahvelerden birini yazın (örneğin, Türk Kahvesi veya turk kahvesi). 
     Bu, case-insensitive (büyük-küçük harfe duyarsız) olması için bir String yöntemi kullanmalıdır.

**Koşul 1:**
   - 
   - "kahve" adında bir String oluşturun.
   - Eğer seçilen kahve Türk Kahvesi ise, "Türk kahvesi hazırlanıyor..." yazdırın. (Düz "Türk kahvesi" yazmayın. String hangiKahve'yi çağırın!!)
   - Eğer Filtre Kahve ise, "Filtre kahve hazırlanıyor..." yazdırın. (String hangiKahve'yi kullanın!!)
   - Eğer Espresso ise, "Espresso hazırlanıyor..." yazdırın. (String hangiKahve'yi kullanın!!)
   - Yanlış bir harf girilirse, "Yanlış tuşlama. Lütfen tekrar deneyin." yazdırın. Not: Yanlış bir giriş yapılırsa, aynı soruyu tekrar sorun.

**Koşul 2:**
   - 
   - Sistem şunu sormalıdır: "Süt eklememizi ister misiniz? (Evet veya Hayır olarak cevaplayınız):"
   - Parantezler dahil olmak üzere konsolda tam olarak bu şekilde görüntüleyin.
   - "süt" adında bir String oluşturun.
   - Eğer cevap "evet" e eşitse, "Süt ekleniyor..." konsolda görünecek. Case-sensitive olmaması için String yöntemini kullanın. Mümkün olan olasılıklar şunlardır: Evet, YES, YeS, YEs vb.
   - Eğer "hayır" ise, "Süt eklenmiyor." yazdırın. Not: Yanlış bir giriş yapılırsa, aynı soruyu tekrar sorun.

**Koşul 3:**
   - 
   - Sistem şunu sormalıdır:** "Şeker ister misiniz? (Evet veya Hayır olarak cevaplayınız):"
   - Parantezler dahil olmak üzere konsolda tam olarak bu şekilde görüntüleyin.
   - Case insensitivity için String yöntemlerini kullanın.
   - "şeker" adında bir String oluşturun.
   - Eğer cevap "evet" e eşitse, sistem "Kaç şeker istersiniz?: " diye sormalıdır. "kacSeker" adında bir int oluşturun ve şeker miktarını girin. Örneğin, "5 şeker ekleniyor." yazdırın.
   - Eğer cevap "hayır" e eşitse, sistem "Şeker eklenmiyor." yazmalıdır. 
   - Not: Yanlış bir giriş yapılırsa, aynı soruyu tekrar sorun.

**Koşul 4:**
   - 
   - Sistem şunu sormalıdır:** "Hangi boyutta istersiniz? (Büyük - Orta - Küçük olarak giriniz.) : "
   - (Büyük veya buyuk gibi) case sensitivity olmamalıdır.
   - "boyut" adında bir String oluşturun.
   - Eğer String "boyut" "Büyük" e eşitse, "Büyük boy kahveniz hazırlanıyor." yazdırın. ( "Kahveniz" + boyut + " boyutta hazırlanıyor." şeklinde String "boyut" kullanın.)
   - Eğer String "size" "Orta boy" e eşitse, "Orta boy kahveniz hazırlanıyor." yazdırın. ( "Kahveniz" + boyut + " boyutta hazırlanıyor." şeklinde String "boyut" kullanın.)
   - Eğer String "size" "Küçük boy" e eşitse, "Küçük boy kahveniz hazırlanıyor." yazdırın. ( "Kahveniz" + boyut + " boyutta hazırlanıyor." şeklinde String "boyut" kullanın.) 
   - Not: Yanlış bir giriş yapılırsa, aynı soruyu tekrar sorun.

**Sonuç Bölümü:**
   - 
   - Siparişlerimizi verdik. Sonucu görmek istiyoruz.
   - Örneğin, konsolda şöyle yazdırın: "Türk kahvesi, orta boy, hazır. Afiyet olsun!"
   - (Türk kahvesi için String "hangiKahve" ve orta boy için String "boyut" kullanın.)
