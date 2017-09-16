Android Programing
----------------------------------------------------
#### 2017.09.15 4일차

###### 예제
____________________________________________________

###### 공부정리
____________________________________________________

  - Widget의 종류

      1. ToggelButton

          - On, Off 로 이루어진 Widget
          - CompoundButton.OnCheckedChangeListener 를 사용하여, On, Off 상태를 알 수 있다.

          - xml 코드

              ```xml
              <ToggleButton
                 android:id="@+id/toggleButton"
                 android:layout_width="wrap_content"
                 android:layout_height="wrap_content"
                 android:text="OFF" />
              ```

          - java 코드

              ``` java

              toggleButton.setOnCheckedChangeListener(checkedChangeListener);

              CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                      // 토글 처리
                      switch (compoundButton.getId()) {
                          case R.id.toggleButton:
                              if (check) {
                                  // Toggle 버튼이 켜짐
                              } else {
                                  // Toggle 버튼이 꺼짐
                              }
                              break;
                      }
                  }
              };
              ```

      2. CheckBox

          - Check 를 할 수 있는 Widget
          - RadioButton Widget 과는 다르게 중복 선택이 가능하다
          - CompoundButton.OnCheckedChangeListener 를 사용하여 check, unCheck 를 알 수 있다.

          - xml 코드

              ```xml
              <CheckBox
                  android:id="@+id/chkDog"
                  android:layout_width="73dp"
                  android:layout_height="29dp"
                  android:text="DOG"/>
              <CheckBox
                  android:id="@+id/chkPig"
                  android:layout_width="70dp"
                  android:layout_height="29dp"
                  android:text="PIG" />
              <CheckBox
                  android:id="@+id/chkCow"
                  android:layout_width="72dp"
                  android:layout_height="28dp"
                  android:text="COW"/>
              ```

          - java 코드

              ```java

              chkDog.setOnCheckedChangeListener(checkboxListener);
              chkPig.setOnCheckedChangeListener(checkboxListener);
              chkCow.setOnCheckedChangeListener(checkboxListener);

              CompoundButton.OnCheckedChangeListener checkboxListener = new CompoundButton.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                      // 체크박스 처리
                      switch (compoundButton.getId()) {
                          case R.id.chkDog:
                              if (check) {
                                  // chkDog Checked
                              } else {
                                  // chkDog unChecked
                              }
                              break;
                          case R.id.chkPig:
                              if (check) {
                                  // chkPig Checked
                              } else {
                                  // chkDog unChecked
                              }
                              break;
                          case R.id.chkCow:
                              if (check) {
                                  // chkCow Checked
                              } else {
                                  // chkCow unChecked
                              }
                              break;
                      }
                  }
              };
              ```

      3. RadioButton

          - Check 를 할 수 있는 Widget
          - 하나의 RadioGroup 안에 RadioButton 이 존재한다면 중복 Check 가 불가능하다.
          - CompoundButton.OnCheckedChangeListener 를 사용하여 단일의 RadioButton의 check, unCheck 를 알 수 있다.
          - RadioButton.OnCheckedChangeListener 를 사용하여 다중의 RadioButton의 check, unCheck 를 알 수 있다. (하나를 선택할 시 다른 RadioButton 은 unChecked가 된다.)

          - xml 코드

              ```xml
              <RadioGroup
                  android:id="@+id/radioGroup"
                  android:layout_width="0dp"
                  android:layout_height="21dp"
                  android:orientation="horizontal">

                  <RadioButton
                      android:id="@+id/radioActivity"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="SPINEER" />

                  <RadioButton
                      android:id="@+id/radioRed"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="RED" />

                  <RadioButton
                      android:id="@+id/radioGreen"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="GREEN" />

                  <RadioButton
                      android:id="@+id/radioBlue"
                      android:layout_width="wrap_content"
                      android:layout_height="wrap_content"
                      android:text="BLUE" />
              </RadioGroup>
              ```

          - java 코드

              ```java

              radioGroup.setOnCheckedChangeListener(radioListener);

              RadioGroup.OnCheckedChangeListener radioListener = new RadioGroup.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(RadioGroup radioGroup, @IdRes int radio_id) {
                      switch (radio_id) {
                          case R.id.radioRed:
                              // radioRed Checked
                              break;
                          case R.id.radioGreen:
                              // radioGreen Checked
                              break;
                          case R.id.radioBlue:
                              // radioBlue Checked
                              break;
                          case R.id.radioActivity:
                              // radioActivity Checked
                              break;
                      }
                  }
              };
              ```

      4. ProgressBar

          - 상태 표시중을 나타낼 수 있는 Widget
          - SetVisible 을 통해 보여주거나 숨겨야 한다.

          - xml 코드

              ```xml
              <ProgressBar
                  android:id="@+id/progressBar"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"/>
              ```

          - java 코드

              ```java
              // INVISIBLE -- 화면에 안보이는데 자리는 차지하고 있는 상태
              // VISIBLE   -- 현재 화면에 보이는 상태
              // GONE      -- 화면에서 사라진 상태

              progressBar.setVisibility(View.INVISIBLE);  
              ```

      5. Switch

          - ToggleButton 과 유사한 Widget
          - 이름 그대로 스위치의 역할을 한다.
          - CompoundButton.OnCheckedChangeListener 를 사용하여, On, Off 상태를 알 수 있다.

          - xml 코드
              ```xml
              <Switch
                android:id="@+id/mSwitch"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="Switch"/>
              ```
          - java 코드

              ```java
              mSwitch.setOnCheckedChangeListener(checkedChangeListener);

              CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean check) {
                        // 스위치 처리
                        switch (compoundButton.getId()) {
                            case R.id.mSwitch:
                                if (check) {
                                    // Switch On
                                } else {
                                    // Switch Off
                                }
                                break;
                        }
                    }
                };
              ```

      6. SeekBar

          - ProgressBar를 확장하여 사용자가 터치로 상태를 변경할 수 있도록 한 Widget
          - 볼륨 조절이나 화면 밝기 조절 등에 사용할 수 있다.
          - SeekBar.OnSeekBarChangeListener 를 사용하여 각종 상태를 알 수 있다.

          - xml 코드

              ```xml
              <SeekBar
                  android:id="@+id/seekBar"
                  android:layout_width="0dp"
                  android:layout_height="wrap_content"
                  android:max="최대크기 설정"
                  android:thumb="아이콘 설정" />
              ```

          - java 코드

              ``` java
              seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                  @Override
                  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                      // onProgressChanged() : 드래그 하는 중에 발생
                  }

                  @Override
                  public void onStartTrackingTouch(SeekBar seekBar) {
                      // onStartTrackingTouch()   :  최초에 탭하여 드래그 시작할때 발생
                  }

                  @Override
                  public void onStopTrackingTouch(SeekBar seekBar) {
                      //  onStopTrackingTouch() : 드래그를 멈출때 발생
                  }
              });              
              ```

      7. RatingBar

          - 평점이나 별점을 줄 때 사용하는 Widget
          - RatingBar.OnRatingBarChangeListener 을 사용하여 변경됬을 때의 상태 값을 알 수 있다.

          - xml 코드

              ```xml
              <RatingBar
                  android:id="@+id/ratingBar"
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:numStars="전체 표시된는 별의 개수"
                  android:rating="최초 시작지 등급"
                  android:stepSize="움직이는 단위"
                  android:max="레이팅 최고 수치" />
              ```

          - java 코드

                ```java
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        // RatingBar 가 변경될 시 발생
                    }
                });
                ```
