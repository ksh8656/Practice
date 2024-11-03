package example;

class Planet {
    private int centerX; // 행성의 중심 X좌표
    private int centerY; // 행성의 중심 Y좌표
    private int radius;  // 행성의 반지름

    // 생성자: 행성의 중심 좌표와 반지름을 초기화
    public Planet(int centerX, int centerY, int radius) {
        this.centerX = centerX; // 클래스의 필드에 매개변수 값을 저장
        this.centerY = centerY;
        this.radius = radius;
    }

    // 주어진 점이 행성 내부에 있는지 여부를 반환
    public boolean isInside(int x, int y) {
        // 거리의 제곱 계산 (제곱근을 사용하지 않고 비교를 위해)
        int distanceSquared = (x - centerX) * (x - centerX) + (y - centerY) * (y - centerY);
        // 점이 행성의 반지름보다 안쪽에 있는지 확인
        return distanceSquared < radius * radius; // 내부 여부 반환
    }
}
