Feature: Validate fucnctionality of home loan calculator




@tag2
Scenario Outline: Validate fucnctionality of application with differant user data

Given Landed on home loan calculator page
When Filling user data "<applicationType>" "<numberOfDependant>" "<properyYouLike>" "<yourAnualIncom>" "<yourOtherIncom>" "<livingExpences>" "<currentHomeLoanRepayment>" "<otherLoan>" "<OtherComitments>" "<creditCardLimit>"
Then  massege is displayed has a borrowing estimate

Examples:
     | applicationType | numberOfDependant | properyYouLike           |yourAnualIncom  |yourOtherIncom |livingExpences  | currentHomeLoanRepayment  | otherLoan  | OtherComitments  | creditCardLimit  |
     |singal		   | 0	               |buying a home to live in  |80000          |10000           |500             |0                          |100         |0                 |10000             |



