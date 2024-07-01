package teachertest0628.teachertest0628;

import com.softagape.sbtest0628.make.PhoneBook;
import com.softagape.sbtest0628.make.PhoneBookJsonRepository;
import com.softagape.sbtest0628.make.PhoneBookServiceImpl;
import com.softagape.sbtest0628.make.PhoneBookTextRepository;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TeacherTest {
    @Test
    public void RepositoryTest() throws Exception {
        String seperator = ",";
        SoftAssertions softAssertions = new SoftAssertions();
        PhoneBookJsonRepository jsonReposiory = new PhoneBookJsonRepository("test.json");
        JSONParser jsonParser = new JSONParser();

        String strJson = "{\"phoneNumber\":\"010-0000-0000\",\"group\":\"Jobs\",\"name\":\"이말자\",\"id\":\"7\",\"email\":\"asdfs@gm.com\"}";
        JSONObject obj = (JSONObject)jsonParser.parse(strJson);
        Throwable ex = assertThrows(Exception.class, () -> jsonReposiory.getObjectFromJson(obj));
        System.out.println(ex.toString());

        strJson = "{\"phoneNumber\":\"010-0000-0000\",\"group\":\"Jobs\",\"name\":\"이말자\",\"id\":7,\"email\":\"asdfs@gm.com\"}";
        Object obj2 = jsonParser.parse(strJson);
        IPhoneBook phoneBook = jsonReposiory.getObjectFromJson((JSONObject)obj2);
        softAssertions.assertThat(phoneBook.getId()).isEqualTo(7L);
        softAssertions.assertThat(phoneBook.getName()).isEqualTo("이말자");
        softAssertions.assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        softAssertions.assertThat(phoneBook.getGroup().toString()).isEqualTo("Jobs");
        softAssertions.assertThat(phoneBook.getPhoneNumber()).isEqualTo("010-0000-0000");
        softAssertions.assertThat(phoneBook.getEmail()).isEqualTo("asdfs@gm.com");

        PhoneBookTextRepository textRepository = new PhoneBookTextRepository("test.json");
        String strText = "3" + seperator + "홍길동" + seperator + "Families" + seperator + "010-1111-1111" + seperator + "abcd@gmail.com";
        ex = assertThrows(Exception.class, () -> textRepository.getObjectFromText(""));
        System.out.println(ex.toString());
        ex = assertThrows(Exception.class, () -> textRepository.getObjectFromText("3" + seperator + "홍길동" + seperator + "Families"));
        System.out.println(ex.toString());
        ex = assertThrows(Exception.class, () -> textRepository.getObjectFromText("aaa" + seperator + "홍길동" + seperator + "Families" + seperator + "010-1111-1111" + seperator + "abcd@gmail.com"));
        System.out.println(ex.toString());
        ex = assertThrows(Exception.class, () -> textRepository.getObjectFromText("3" + seperator + "홍길동" + seperator + "families" + seperator + "010-1111-1111" + seperator + "abcd@gmail.com"));
        System.out.println(ex.toString());

        softAssertions.assertAll();
    }

    @Test
    public void ServiceTest() throws Exception {
        SoftAssertions softAssertions = new SoftAssertions();
        File jsonFile = new File("teach.json");
        File textFile = new File("teach.txt");
        jsonFile.delete();
        textFile.delete();
        assertThat(jsonFile.exists()).isEqualTo(false);
        assertThat(textFile.exists()).isEqualTo(false);
        IPhoneBookService<IPhoneBook> jsonService = new PhoneBookServiceImpl("-j", "teach.json");
        IPhoneBookService<IPhoneBook> textService = new PhoneBookServiceImpl("-t", "teach.txt");

        softAssertions.assertThat(jsonService.size()).isEqualTo(0);
        softAssertions.assertThat(textService.size()).isEqualTo(0);
        softAssertions.assertThat(jsonService.getMaxId()).isEqualTo(1L);
        softAssertions.assertThat(textService.getMaxId()).isEqualTo(1L);

        softAssertions.assertThat(jsonService.insert("김길동", EPhoneGroup.Friends, "010-1111-1111", "kim01@naver.com")).isEqualTo(true);
        softAssertions.assertThat(jsonService.insert("이순신", EPhoneGroup.Families, "010-1111-2222", "lee01@naver.com")).isEqualTo(true);
        softAssertions.assertThat(jsonService.insert("이성계", EPhoneGroup.Hobbies, "010-1111-3333", "lee02@naver.com")).isEqualTo(true);
        softAssertions.assertThat(jsonService.getMaxId()).isEqualTo(4L);
        softAssertions.assertThat(jsonService.insert("을지문덕", EPhoneGroup.Friends, "010-1111-4444", "moon01@naver.com")).isEqualTo(true);
        softAssertions.assertThat(jsonService.insert("신사임당", EPhoneGroup.Families, "010-1111-5555", "sin01@naver.com")).isEqualTo(true);
        softAssertions.assertThat(textService.insert("김길동", EPhoneGroup.Friends, "010-1111-1111", "kim01@naver.com")).isEqualTo(true);
        softAssertions.assertThat(textService.insert("이순신", EPhoneGroup.Families, "010-1111-2222", "lee01@naver.com")).isEqualTo(true);
        softAssertions.assertThat(textService.insert("이성계", EPhoneGroup.Hobbies, "010-1111-3333", "lee02@naver.com")).isEqualTo(true);
        softAssertions.assertThat(textService.getMaxId()).isEqualTo(4L);
        softAssertions.assertThat(textService.insert("을지문덕", EPhoneGroup.Friends, "010-1111-4444", "moon01@naver.com")).isEqualTo(true);
        softAssertions.assertThat(textService.insert("신사임당", EPhoneGroup.Families, "010-1111-5555", "sin01@naver.com")).isEqualTo(true);

        softAssertions.assertThat(this.findIndexById(jsonService.getAllList(), 2L)).isEqualTo(1);
        softAssertions.assertThat(this.findIndexById(textService.getAllList(), 4L)).isEqualTo(3);

        softAssertions.assertThat(jsonService.size()).isEqualTo(5);
        softAssertions.assertThat(jsonService.getMaxId()).isEqualTo(6L);
        softAssertions.assertThat(textService.size()).isEqualTo(5);
        softAssertions.assertThat(textService.getMaxId()).isEqualTo(6L);

        softAssertions.assertThat(jsonService.remove(2L)).isEqualTo(true);
        softAssertions.assertThat(jsonService.remove(4L)).isEqualTo(true);
        softAssertions.assertThat(jsonService.size()).isEqualTo(3);
        softAssertions.assertThat(jsonService.getMaxId()).isEqualTo(6L);
        softAssertions.assertThat(textService.remove(2L)).isEqualTo(true);
        softAssertions.assertThat(textService.remove(4L)).isEqualTo(true);
        softAssertions.assertThat(textService.size()).isEqualTo(3);
        softAssertions.assertThat(textService.getMaxId()).isEqualTo(6L);

        IPhoneBook uObject = PhoneBook.builder().name("김성량").build();
        softAssertions.assertThat(jsonService.update(3L, uObject)).isEqualTo(true);
        IPhoneBook find = jsonService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김성량");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Hobbies);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-1111-3333");
        softAssertions.assertThat(find.getEmail()).isEqualTo("lee02@naver.com");

        softAssertions.assertThat(textService.update(3L, uObject)).isEqualTo(true);
        find = textService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김성량");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Hobbies);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-1111-3333");
        softAssertions.assertThat(find.getEmail()).isEqualTo("lee02@naver.com");

        uObject = PhoneBook.builder().group(EPhoneGroup.Jobs).build();
        softAssertions.assertThat(jsonService.update(3L, uObject)).isEqualTo(true);
        find = jsonService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김성량");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-1111-3333");
        softAssertions.assertThat(find.getEmail()).isEqualTo("lee02@naver.com");

        softAssertions.assertThat(textService.update(3L, uObject)).isEqualTo(true);
        find = textService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김성량");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-1111-3333");
        softAssertions.assertThat(find.getEmail()).isEqualTo("lee02@naver.com");

        uObject = PhoneBook.builder().phoneNumber("010-3333-9999").build();
        softAssertions.assertThat(jsonService.update(3L, uObject)).isEqualTo(true);
        find = jsonService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김성량");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-3333-9999");
        softAssertions.assertThat(find.getEmail()).isEqualTo("lee02@naver.com");

        softAssertions.assertThat(textService.update(3L, uObject)).isEqualTo(true);
        find = textService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김성량");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-3333-9999");
        softAssertions.assertThat(find.getEmail()).isEqualTo("lee02@naver.com");

        uObject = PhoneBook.builder().name("김김김").email("kimsung@gmail.com").build();
        softAssertions.assertThat(jsonService.update(3L, uObject)).isEqualTo(true);
        find = jsonService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김김김");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-3333-9999");
        softAssertions.assertThat(find.getEmail()).isEqualTo("kimsung@gmail.com");

        softAssertions.assertThat(textService.update(3L, uObject)).isEqualTo(true);
        find = textService.findById(3L);
        softAssertions.assertThat(find).isNotNull();
        softAssertions.assertThat(find.getName()).isEqualTo("김김김");
        softAssertions.assertThat(find.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        softAssertions.assertThat(find.getPhoneNumber()).isEqualTo("010-3333-9999");
        softAssertions.assertThat(find.getEmail()).isEqualTo("kimsung@gmail.com");

        softAssertions.assertAll();
    }

    private int findIndexById(List<IPhoneBook> arr, long id) {
//        for ( int i = 0; i < arr.size(); i++ ) {
//            if ( id.equals(arr.get(i).getId()) ) {
//                return i;
//            }
//        }
//        return -1;
        IPhoneBook find = PhoneBook.builder().id(id).build();
        int findIndex = Arrays.binarySearch(arr.toArray(IPhoneBook[]::new)
                , find
                , PhoneBook.ORDER_GREAT);
        return findIndex;
    }
}
