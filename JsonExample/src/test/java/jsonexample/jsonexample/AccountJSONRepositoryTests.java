package jsonexample.jsonexample;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountJSONRepositoryTests {
    @Test
    public void JsonToObjectTest() {
        // given 초기값을 준다.
        String json = "{\"bankAccount\":\"222222\",\"current\":20000,\"name\":\"bbbbb\"}";
        // when 테스트할 값을 만든다.
        JSONParser jsonParser = new JSONParser();
        Account account = null;
        try {
            // String 문자열을 JSON 객체로 변환한다.
            Object obj = jsonParser.parse(json);
            // JSON 객체를 Account 객체로 변환한다.
            account = getAccountFromJson((JSONObject)obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // then assertThat 으로 검사한다.
        assertThat(account.getName()).isEqualTo("bbbbb");
        assertThat(account.getBankNumber()).isEqualTo("222222");
        assertThat(account.getCurrent()).isEqualTo(20000);
    }

    private Account getAccountFromJson(JSONObject jsonObject) throws Exception {
        if ( jsonObject == null ) {
            throw new Exception("jsonObject is null error");
        }
        Account account = new Account();
        account.setName( (String)jsonObject.get("name") );
        account.setBankNumber( (String)jsonObject.get("bankAccount") );
        account.setCurrent( ((Long)jsonObject.get("current")).intValue() );
        return account;
    }

    @Test
    public void ObjectToJsonTest() {
        // given 초기값을 준다.
        Account account = new Account("aaaaa", "11111", 70000);
        // when 테스트할 값을 만든다.
        String str = "";
        try {
            // Account 객체를 JSON 객체로 변환한다.
            JSONObject json = getJsonFromObject(account);
            // JSON 객체를 String 문자열로 변환한다.
            str = json.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // then assertThat 으로 검사한다.
        assertThat(str).isEqualTo("{\"bankAccount\":\"11111\",\"current\":70000,\"name\":\"aaaaa\"}");
    }

    private JSONObject getJsonFromObject(Account account) throws Exception {
        if ( account == null ) {
            throw new Exception("account is null error");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", account.getName());
        jsonObject.put("bankAccount", account.getBankNumber());
        jsonObject.put("current", account.getCurrent());
        return jsonObject;
    }

    @Test
    public void checkSizeOfArrayFromJSonString() {
        // given, when
        String str = "{\"accounts\":[{\"bankAccount\":\"11111\",\"current\":70000,\"name\":\"aaaaa\"},{\"bankAccount\":\"222222\",\"current\":20000,\"name\":\"bbbbb\"},{\"bankAccount\":\"3333\",\"current\":30000,\"name\":\"ccccc\"}]}";
        // then
        // when 테스트할 값을 만든다.
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            // String 문자열을 JSON 객체로 변환한다.
            JSONObject obj = (JSONObject)jsonParser.parse(str);
            // JSON 객체를 Account 객체로 변환한다.
            jsonArray =  (JSONArray)obj.get("accounts");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(jsonArray).isNotNull();
        assertThat(jsonArray.size()).isEqualTo(3);
    }
}