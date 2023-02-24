package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 로그 사용시 장점
 * 쓰레드정보, 클래스 이름 같은 부가 정볼르 함께 볼 수 있고, 출력 모양 결정
 * 로그 레벨에 따라 개발서버에서 모든 로그출력, 운영서버에서는 출력하지 않게 설정 가능
 * System.out콘솔에만 출력하는 것이 아닌 파일, 네트워크 등, 로그를 별도의 위치에 남길 수 있음
 * 특히, 파일로 남길 때는 일별, 특정 용량에 따라 로그를 분할하는 것이 가능
 * 성능도 일반 System.Out보다 좋음
 */

@Slf4j
@RestController // @Controller는 반환 값이 String이면 view이름으로 인식, REST는 HTTP 메시지 바디에 바로 입력
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);
        // LEVEL : TRACE > DEBUG > INFO > WARE > ERROR
        // 보통 개발서버는 debug출력, 운영서버는 info 출력

        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 메모리 등 리소스를 잡아 먹으므로 사용하면 X
        //log.debug("debug=" + name);
        //로그 레벨 설정하려면 application.properties
        return "ok";
    }
}
