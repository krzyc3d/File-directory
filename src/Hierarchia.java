/*
Przygotuj program, który wydrukuje na ekran hierarchiczną zależność katalogów:
nazwy podkatalogów i plików mają być przesunięte w prawo w stosunku do katalogu nadrzędnego.
Przygotuj wersję rekurencyjną i iteracyjną.
Rekurencyjna wersja:
func drzewo (wcięcie, plik)
  wyświetl wcięcie
  wyświetl nazwę pliku
  jeżeli aktualny plik jest folderem
    wywołaj rekurencyjnie aktualną funkcję jako parametry dając wcięcie powiększone o spację oraz listę plików w tym folderze
Wywołaj funkcję dla folderu z projektami.
* hint: sprawdzenie czy plik jest katalogiem:
  File f = new File(path);
  f.isDirectory()
* hint: pobranie plików w danym katalogu:
  File f = new File(path);
  f.listFiles();
 */
import java.io.File;

public class Hierarchia {

    public static void main(String[] args) {
        printFileList("C:\\Users\\krzych3D\\IdeaProjects\\PlikiJHierarchia48");
    }

    private static void printFileList(String startingPath) {
        File directory = new File(startingPath);
        System.out.println(directory.getName());
        String indent = "   ";
        inDirectoryReader(indent, directory);
    }

    private static void inDirectoryReader(String indent, File directory) {
        StringBuilder indentBuilder = new StringBuilder(indent);
        for (File file : directory.listFiles()) {
            indentBuilder.append("   ");
            System.out.println(indentBuilder + file.getName());
            if (file.isDirectory()) {
                indentBuilder.append("   ");
                inDirectoryReader(indentBuilder.toString(), file);
                indentBuilder = new StringBuilder("   ");
            }
        }
        indent = indentBuilder.toString();
    }
}