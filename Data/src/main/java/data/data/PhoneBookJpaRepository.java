package data.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneBookJpaRepository extends JpaRepository<PhoneBookEntity, Long>{
    // PhoneBookEntity JPA 로 연결된 데이터에서 Name 컬럼에서 name 글자가 포함된 자료를 찾아서
    // 배열로 리턴하는 SQL 문장을 싱행하는 메소드를 사용한다.
    List<PhoneBookEntity> findAllByNameContains(String name);

    // PhoneBookEntity JPA 로 연결된 데이터에서 Category 컬럼에서 category 글자가 포함된 자료를 찾아서
    // 배열로 리턴하는 SQL 문장을 싱행하는 메소드를 사용한다.
    // List<PhoneBookEntity> findAllByCategoryContains(String category);

    // PhoneBookEntity JPA 로 연결된 데이터에서 Category 컬럼에서 category 가 같은 자료를 찾아서
    // 배열로 리턴하는 SQL 문장을 싱행하는 메소드를 사용한다.
    List<PhoneBookEntity> findAllByCategory(ECategory category);

    // PhoneBookEntity JPA 로 연결된 데이터에서 phoneNumber 컬럼에서 phoneNumber 글자가 포함된 자료를 찾아서
    // 배열로 리턴하는 SQL 문장을 싱행하는 메소드를 사용한다.
    List<PhoneBookEntity> findAllByPhoneNumberContains(String phoneNumber);

    // PhoneBookEntity JPA 로 연결된 데이터에서 email 컬럼에서 email 글자가 포함된 자료를 찾아서
    // 배열로 리턴하는 SQL 문장을 싱행하는 메소드를 사용한다.
    List<PhoneBookEntity> findAllByEmailContains(String email);

}
