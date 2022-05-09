PQUQCF	

Lényegében a programom egy klinikai listázáshoz lehet használni, vagyis egészségügyi a témája. Minden lista elem egy objektum a patient osztályból, aminek 5 attribútuma van, azonosító, név, születési dátum, kezelés kezdete és betegség neve. Véleményem szerint ezek elegendő tudnivalók, hogy valaki megállapíthassa kiről van szó és milyen állapotban van. 

A "betegeket" xml fájlból olvassa be még a main metódus előtt a program és egy arraylist-ben tárolja őket mentésig, vagy kilépésig. Az objektum minden attribútuma String, mert azokkal sokkal könnyebb dolgozni és nem fog hiba történni, ha nem jó a bevitt adat típusa. A mentés egy külön metódus, ami csak kilépéskor automatikus, tehát érdemes menteni program futása közben, különben az adatok elveszhetnek.

A programban a main metódus egyenesen egy menü metódusba visz, ahol egy switch-csel hét opció közül lehet választani: listázás, hozzáadás, törlés, módosítás, keresés, mentés és kilépés. A minimális 4 funkció mellé még készítettem egy kereső metódust is, hogy mégiscsak, ha túl sok a beteg, akkor meg lehessen találni azonosító alapján.

Ha választottunk, mit szeretnénk csinálni, akkor a switch elindítja azt a metódust, aminek a végén egy esetleg egy üzenet szerepel, majd egy kis szünet és visszavisz a menü metódushoz, ezzel egy loopot generálva, aminek a végén kiléphetünk a programból.


A program részletes leírása:

(intellij-ben nem lehet console-t törölni)

public class Main{
	A main classban létrehoztam egy változót, ami egy boolean-ként működik, de integer, mivel azokban jobban bízok. Ezután olvassa be egy arraylistbe az elemeket a beolvasó metódus, ami egyébként sokkal eredményesebben olvas be, ha nem ejtünk benne helyesírás problémákat. Az órai beolvasó metódust alakítottam át, hogy ehhez a programhoz működjön.

	psvm{
	A mainben csak egy "lehetosegek();" szerepel, mert eleinte a mainbe akartam mindig visszavezetni a loopot, viszont ez elég kellemetlen, mert a mainnek szüksége van egy String[]-re, ezt orvosolja a menü metódus, aminek nem kell semmit adni hogy működjön.	
	}

	lehetosegek(){
	Létrehoztam egy "i" változót, ami a switchnek kell majd.
	Kiírja a lehetőségeinket és vár egy bevitelt, ami eldönti mi következik. Amikor a mainben csináltam a switchet, akkor semmi gond nem volt, viszont miután áttettem egy külön metódusba, általam ismeretlen okoból, átugrott egy adatbevitelt, szóval ahol egy üres kiírás és egy biveitel van, ott ez van orvosolva. Próbálkoztam breakkel, de nem igazán szeretett volna úgy sem működni sajnos.
}

	enter(){
	Ez egy egyszerű metódus, ahhoz, hogy egy kis szünet történjen, mert kellemetlennek találtam, ahogy megtörtént a kért metódus és egyből visszadobott a lehetőségek metódushoz.
}

	listaza(){
	Ez is egy rendkívül egyszerű metódus, ami tényleg csak listázza az arraylistet, amit még main előtt olvastunk be. Egy "i" változó addig növekszik amíg akkora nem lesz, mint a lista mérete, közben minden elemet és annak attribútumait kiírja.

	hozzad(){
	Ez a metódus ad hozzá új elemet az arraylisthez. Bekéri az attribútumokat és a patient osztály konstruktorával létrehoz egy új objektumot. Ha sikeres volt a hozzáadás (mindig az), akkor egy üzenettel ezt jelzi a feéhasználónak. 
}

	torles(){
	Azonosító alapján megkeresi az adott elemet és azt törli. Ha nem talál ilyen azonosítót, akkor üzenettel ezt jelzni a felhsaználónak, majd megy újra elindítja a lehetőségek metódust, ezzel visszatérve a loopba.
}

	frissites(){
	Azonosító alapján lehet keresni a beteget és ha nem találja, akkor sincsen semmi probléma, eredetileg sorszámmal volt megoldva ez a metódus. Switch-csel dönthetünk a frissítendő attribútumról. Itt is előjön a switches dolog, hogy bevitelt ugrik, ezért ugyanazzal orvosoltam a problémát.
}
	
	kereses(){
	Gyakorlatilag azonos a törlés metódussal, csak itt nem törli az elemet, hanem kiírja ha megtalálta.
}

	savePatientsToXml() és readPatientsFromXml(){
	Órai munkából lett átdolgozva, hogy ezeket a fájlokat és adatokat tudják kezelni.
} 
}
