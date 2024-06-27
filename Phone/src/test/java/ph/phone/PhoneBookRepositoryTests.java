package ph.phone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class PhoneBookRepositoryTests {
    public PhoneBookRepositoryTests() throws ParseException {
    }

    @Test
    public void jsonRepositoryTest() throws Exception {
        PhoneBookJSONRepository repository = new PhoneBookJSONRepository("data.json");
        //대부분의 값은 ""으로 하는게 좋다 ex) jobs말고 "jobs"
        String json = "{\"phoneNumber\":\"010-0000-0000\",\"group\":\"Jobs\", \"name\":\"이말자\",\"id\":7,\"email\":\"asdfqwe@asd.com\"}";
        JSONParser jsonParser = new JSONParser();
        IPhoneBook object = null;
        // String 문자열을 JSON 객체로 변환
        Object obj = jsonParser.parse(json);
        // JSON 객체를 Account 객체로 변환
        object = repository.getObjsctFromJson((JSONObject) obj);
        assertThat(object.getId()).isEqualTo(7L);
        assertThat(object.getName()).isEqualTo("이말자");
        assertThat(object.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        assertThat(object.getPhoneNumber()).isEqualTo("010-0000-0000");
        assertThat(object.getEmail()).isEqualTo("asdfqwe@asd.com");

        IPhoneBook iPhoneBook2 = new PhoneBook();
        iPhoneBook2.setId(12L);
        iPhoneBook2.setName("홍길동");
        iPhoneBook2.setGroup(EPhoneGroup.Hobbies);
        iPhoneBook2.setPhoneNumber("1111-2134");
        iPhoneBook2.setEmail("asdqwegvgg@asd.com");
        JSONObject jobject = repository.getJsonFromObject((iPhoneBook2));
        assertThat((Long) jobject.get("id")).isEqualTo(12L);
        assertThat((String) jobject.get("name")).isEqualTo("홍길동");
        assertThat((String) jobject.get("group")).isEqualTo("Hobbies");
        assertThat(EPhoneGroup.valueOf((String)jobject.get("group"))).isEqualTo(EPhoneGroup.Hobbies);
        assertThat((String) jobject.get("phoneNumber")).isEqualTo("1111-2134");
        assertThat((String) jobject.get("email")).isEqualTo("asdqwegvgg@asd.com");
        assertThat(jobject.toString()).isEqualTo("{\"phoneNumber\":\"1111-2134\",\"name\":\"홍길동\",\"id\":12,\"email\":\"asdqwegvgg@asd.com\",\"group\":\"Hobbies\"}");
    }

    @Test
    public void TextRepositoryTests() throws Exception {
        PhoneBookTextRepository repository = new PhoneBookTextRepository("data.txt");
        Throwable ex = assertThrows(Exception.class, () -> repository.getObjectFromText(""));
        System.out.println(ex.toString());

        IPhoneBook phoneBook = repository.getObjectFromText("3,안순정,Jobs,010-1111-9999,ahns@gmail.com");
        assertThat(phoneBook.getId()).isEqualTo(3L);
        assertThat(phoneBook.getName()).isEqualTo("안순정");
        assertThat(phoneBook.getGroup()).isEqualTo(EPhoneGroup.Jobs);
        assertThat(phoneBook.getGroup().toString()).isEqualTo("Jobs");
        assertThat(phoneBook.getPhoneNumber()).isEqualTo("010-1111-9999");
        assertThat(phoneBook.getEmail()).isEqualTo("ahns@gmail.com");

        String str = repository.getTextFromObject(phoneBook);
        assertThat(str).isEqualTo("3,안순정,Jobs,010-1111-9999,ahns@gmail.com\n");


    }
}