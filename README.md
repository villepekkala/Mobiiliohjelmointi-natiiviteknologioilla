# Kotlinperusteet-viikko1
Viikko1 kotitehtävät

# APK linkki
https://github.com/villepekkala/Mobiiliohjelmointi-natiiviteknologioilla/raw/refs/heads/main/app-debug.apk

## Toiminnot

- **Tehtävälista**  
  Näyttää listan tehtävistä, joissa on otsikko, kuvaus, määräpäivä ja tila (valmis/kesken).

- **Lisää tehtävä**  
  Luo uuden tehtävän, joka lisätään sekä nykyiseen että alkuperäiseen tehtävälistaan.

- **Vain valmiit**  
  Suodattaa tehtävälistasta kaikki valmiiksi merkityt tehtävät.

- **Järjestä**  
  Järjestää nykyisen listan tehtävät määräpäivän mukaan nousevaan järjestykseen.

- **Palauta**  
  Palauttaa alkuperäisen tehtävälistan, mukaan lukien kaikki lisäämäsi tehtävät.

- **Tehtävän tila**  
  Napin avulla voit merkitä tehtävän valmiiksi tai peruuttaa valmiiksi merkityksen.



### `ui/HomeScreen.kt`
- Sisältää `HomeScreen`-Composable-funktion, joka näyttää käyttöliittymän

  ### `domain/Task.kt`
- `Task`-data class: kuvaa yksittäistä tehtävää (id, otsikko, kuvaus, määräpäivä String muodossa, valmis/kesken boolean).
- `mockTasks`: esimerkkilista tehtävistä.
- `addTask()`: lisää uuden tehtävän listaan.
- `Done()`: muuttaa tehtävän tilan valmiiksi/kesken.
- `filterByDone()`: suodattaa tehtävät valmiiden/kesken olevien mukaan.
- `sortByDueDate()`: järjestää tehtävät määräpäivän mukaan.
